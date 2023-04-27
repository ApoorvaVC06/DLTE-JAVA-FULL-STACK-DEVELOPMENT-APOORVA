package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class BankService implements BankOperations, UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    ResourceBundle resourceBundle=ResourceBundle.getBundle("bank");

    private Logger logger= LoggerFactory.getLogger(BankService.class);    //logger

    public List<Customer> listAll(){
        return jdbcTemplate.query("select * from customer",new CustomersMapper());
    }

    //to get the customer object using username
    @Override
    public Customer getByUsername(String username) {
        try{
            logger.info("Entered getByUsername() method");
            Customer customer = jdbcTemplate.queryForObject("select * from Customer where username=?", new CustomersMapper(), username);
            logger.info(customer.toString()+" has been returned to controller");
            return customer;
        }
        catch (Exception e){
            logger.error("Exception occured in getByUsername method: "+e);
            return null;
        }
    }



    //get the number of login attempts left for the logged customer
    public int getAttempts(int id) {
        int attempts=jdbcTemplate.queryForObject("select attempts from customer where customer_id=?",Integer.class,id);
        logger.info(attempts+" attempts are left to login");
        return attempts;
    }

    //decrement attempts for wrong credentials
    public void decrementAttempts(int id) {
       jdbcTemplate.update("update customer set attempts=attempts-1 where customer_id=?", id);
       logger.info("1 attempt is decremented");
    }


    //set attempts as 3 for successful login
    public void setAttempts(int id) {
        jdbcTemplate.update("update customer set attempts=3 where customer_id=?",id);
        logger.info("Attempts is set to 3 for successful login");
    }


    //make status as inactive after 3 unsussessful login
    public void updateStatus() {
         jdbcTemplate.update("update customer set customer_status='Inactive' where attempts=0");
    }

    public void resetStatus(int id) {
        jdbcTemplate.update("update customer set customer_status='active' where customer_id=?",id);
    }

    //to get payee details from DB - SOAP service
    @Override
    public List<Payee> listPayee(String username){
        logger.info("Payees are about to be retrieved from table");
        return jdbcTemplate.query("Select * from payee join customer on customer.customer_id = payee.customer_id where customer.username=? ",new PayeeMapper(),username);
    }


    //insert into Transaction table- make a new payment - REST service
    @Override
    public String newPayment(Transaction transaction){
        String acknowledgment=resourceBundle.getString("transaction");
         logger.info(transaction.toString());
          Double balance= getbalance(transaction.getTransactionFrom());
         if (balance<transaction.getTransactionAmt()){              //check balance
             return resourceBundle.getString("noBalance");
         }
         else {
             jdbcTemplate.update("insert into transaction values(txn_id_seq.nextval,?,?,?,?,CURRENT_DATE )", new Object[]{transaction.getTransactionFrom(), transaction.getTransactionTo(), transaction.getTransactionAmt(), transaction.getTransactionStatus()});

         }
         return acknowledgment;
    }


    //list all the transactions
    @Override
    public List<Transaction> allTransactions() {
        List<Transaction> transactionList= jdbcTemplate.query("select * from transaction",new TransactionMapper());
        return transactionList;
    }

    //get the account balance of sender
    Double getbalance(long transFrom){
       return jdbcTemplate.queryForObject("select ACCOUNT_AVL_BALANCE from ACCOUNT where account_number=?",Double.class,transFrom);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Entered loadByUsername() method");
        Customer customer = getByUsername(username);

        if (customer == null){
            throw new UsernameNotFoundException(resourceBundle.getString("notExist"));
        }
        logger.info("Leaving loadByUsername() method");
        if (customer.getCustomer_status().equalsIgnoreCase("inactive")){
            throw new UsernameNotFoundException(resourceBundle.getString("deactivate"));
        }
        return customer;
    }

    //retrieve customer object from DB
    class CustomersMapper implements RowMapper<Customer > {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer=new Customer();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setCustomer_name(rs.getString("customer_name"));
            customer.setCustomer_address(rs.getString("customer_address"));
            customer.setCustomer_status(rs.getString("customer_status"));
            customer.setCustomer_contact(rs.getLong("customer_contact"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            //logger.info(customer.getCustomer_name()+" details received from database");
            return customer;
        }
    }

    //retrieve payee object from DB
    class PayeeMapper implements RowMapper<Payee>{

        @Override
        public Payee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Payee payee=new Payee();
            payee.setPayeeId(rs.getInt("payee_id"));
            payee.setPayeeName(rs.getString("payee_name"));
            payee.setPayeeAccNum(rs.getLong("payee_account_number"));
            payee.setCustomerId(rs.getInt("customer_id"));
            logger.info(payee.getPayeeName()+" details received from payee table");
            logger.info(String.valueOf(payee));
            return payee;
        }
    }

    //retrieve Transaction object from DB
    class TransactionMapper implements RowMapper<Transaction>{

        @Override
        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transaction transaction=new Transaction();
            transaction.setTransactionId(rs.getInt("txn_id"));
            transaction.setTransactionFrom(rs.getLong("txn_from"));
            transaction.setTransactionTo(rs.getLong("txn_to"));
            transaction.setTransactionAmt(rs.getFloat("txn_amount"));
            transaction.setTransactionStatus(rs.getString("txn_status"));
            transaction.setTransactionDate(rs.getDate("trans_date"));
            logger.info(" details received from transaction table");
            logger.info(String.valueOf(transaction));
            return transaction;
        }
    }

}

