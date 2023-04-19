package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    @Override
    public Customer getByUsername(String username) {
        Customer customer = jdbcTemplate.queryForObject("select * from Customer where username=?", new CustomersMapper(), username);
        return customer;
    }

    //Login service before adding secrity
    @Override
    public String Login(String username, String password) {
        try {
            Customer customer = jdbcTemplate.queryForObject("select * from customer where username=?", new CustomersMapper(), username);
            if (customer == null)  {                                      // if it is null, return not exits
                return resourceBundle.getString("notExist");
            }
            else {
                logger.info(customer.getCustomer_name() + " Account status is " + customer.getCustomer_status());   //get the customer status
                if (customer.getCustomer_status().equalsIgnoreCase("Inactive"))                   //if inactive, return inative
                    return resourceBundle.getString("deactivate");
                if (!password.equals(customer.getPassword())) {                                                //check for correct password
                     decrementAttempts(customer.getCustomer_id());
                     int attempts= getAttempts(customer.getCustomer_id());
                      if(attempts==2) {
                          logger.info(resourceBundle.getString("two"));
                          return resourceBundle.getString("wrongPass");
                      }
                      else if(attempts==1){
                          logger.info(resourceBundle.getString("one"));
                          return resourceBundle.getString("wrongPass");
                      }
                      else{
                          updateStatus();
                          logger.info(resourceBundle.getString("notExist"));
                          return resourceBundle.getString("notExist");
                      }
                }
                else {
                    setAttempts(customer.getCustomer_id());
                    return resourceBundle.getString("success");
                }
            }
        }
        catch (DataAccessException e){
            logger.info("from dao");
            return resourceBundle.getString("notExist");
        }
    }

    //get the number of login attempts left for the logged customer
    public int getAttempts(int id) {
        int attempts=jdbcTemplate.queryForObject("select attempts from customer where customer_id=?",Integer.class,id);
        return attempts;
    }
    //decrement attempts for wrong credentials
    public void decrementAttempts(int id) {
       jdbcTemplate.update("update customer set attempts=attempts-1 where customer_id=?", id);
    }


    //set attempts as 3 for successful login
    public void setAttempts(int id) {
        jdbcTemplate.update("update customer set attempts=3 where customer_id=?",id);
    }


    //make satus as inactive after
    public void updateStatus() {
         jdbcTemplate.update("update customer set customer_status='Inactive' where attempts=0");
    }


    //to get payee details from DB
    @Override
    public List<Payee> listPayee(String username){
        logger.info(" Get by username ");
        return jdbcTemplate.query("Select * from payee join customer on customer.customer_id = payee.customer_id where customer.username=? ",new PayeeMapper(),username);
    }


    //insert into Transaction table- make a new payment
    @Override
    public String newPayment(Transaction transaction){
        String acknowledgment="Transaction successful in DB";
//         logger.info(transaction.toString());
//          Double balance= getbalance(transaction.getTransactionFrom());
//         if (balance<transaction.getTransactionAmt()){              //check balance
//             return resourceBundle.getString("noBalance");
//         }
//         else {
//             Double newBalance=balance-transaction.getTransactionAmt();
             jdbcTemplate.update("insert into transaction values(txn_id_seq.nextval,?,?,?,?,CURRENT_DATE )", new Object[]{transaction.getTransactionFrom(), transaction.getTransactionTo(), transaction.getTransactionAmt(), transaction.getTransactionStatus()});
//             updateBalance(newBalance,transaction.getTransactionFrom());        //update new balance
//             if(ack!=1){
//             return "Failed";}
//         }
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

    //reduce the balance of sender after the payment
    int updateBalance(Double bal,Long transFrom){
        return jdbcTemplate.update("update ACCOUNT set ACCOUNT_AVL_BALANCE=? where ACCOUNT_NUMBER=?",bal,transFrom);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer= getByUsername(username);
        if(customer == null){
            throw new UsernameNotFoundException("Invalid user");
        }
        return customer;
    }

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

    class PayeeMapper implements RowMapper<Payee>{

        @Override
        public Payee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Payee payee=new Payee();
            payee.setPayeeId(rs.getInt("payee_id"));
            payee.setPayeeName(rs.getString("payee_name"));
            payee.setPayeeAccNum(rs.getLong("payee_account_number"));
            payee.setCustomerId(rs.getInt("customer_id"));
            logger.info(payee.getPayeeName()+" details received from payee table");
            return payee;
        }
    }

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
            return transaction;
        }
    }

}

