package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Service

public class BankService implements BankOperations{
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
                          return resourceBundle.getString("wrongpass");
                      }
                      else if(attempts==1){
                          logger.info(resourceBundle.getString("one"));
                          return resourceBundle.getString("wrongpass");
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


    public int getAttempts(int id) {
        int attempts=jdbcTemplate.queryForObject("select attempts from customer where customer_id=?",Integer.class,id);
        return attempts;
    }

    public void decrementAttempts(int id) {
       jdbcTemplate.update("update customer set attempts=attempts-1 where customer_id=?", id);
    }


    public void setAttempts(int id) {
        jdbcTemplate.update("update customer set attempts=3 where customer_id=?",id);
    }

    public void updateStatus() {
         jdbcTemplate.update("update customer set customer_status='Inactive' where attempts=0");
    }



    //to get payee details
    @Override
    public List<Payee> getByCustId(int cust_id) {
        List<Payee> payeeList= jdbcTemplate.query("select * from payee where customer_id=?",new PayeeMapper(),cust_id);
        logger.info("getting payee details");
        return  payeeList;
    }

    @Override
    public String insert(Transaction transaction) throws ParseException {
         String ack="inserted";
        SimpleDateFormat fmt=new SimpleDateFormat("dd-MM-yyyy");
        Date date = fmt.parse(transaction.getTransactionDate());
         jdbcTemplate.update("insert into transaction values(txn_id_seq.nextval,?,?,?,?,?)",new Object[]{transaction.getTransactionFrom(),transaction.getTransactionTo(),transaction.getTransactionAmt(),transaction.getTransactionStatus(),date});
         return ack;
    }

    @Override
    public List<Transaction> allTransactions() {
        List<Transaction> transactionList= jdbcTemplate.query("select * from transaction",new TransactionMapper());
        return transactionList;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer= getByUsername(username);
//        if(customer == null){
//            throw new UsernameNotFoundException("Invalid user");
//        }
//        return customer;
//    }


//    public void incrementFailedAttempts(int id) {
//        jdbcTemplate.update("update CUSTOMER set FAILED_ATTEMPTS = FAILED_ATTEMPTS + 1 where CUSTOMER_ID=?",id);
//        jdbcTemplate.update("update CUSTOMER set CUSTOMER_STATUS='Inactive' where FAILED_ATTEMPTS=3");
//    }

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
            logger.info(customer.getCustomer_name()+" details received from database");
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
            return null;
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
            transaction.setTransactionDate(rs.getString("trans_date"));
            logger.info(" details received from transaction table");
            return transaction;
        }
    }

}

