package bank.project.dao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
class DaoApplicationTests {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    BankService bankService;

private Logger logger= LoggerFactory.getLogger(DaoApplicationTests.class);    //logger

    //test to add a new Transaction- REST service
    @Test
        void newPaymentTest() throws ParseException {
        Transaction transaction1=new Transaction(9876,43239696L,06765L,7676.98f,"fail",new Date());
        Transaction transaction2=new Transaction(9876,076545L,0656L,86567.8f,"Succes",new Date());
        when(jdbcTemplate.update(eq("insert into transaction values(txn_id_seq.nextval,?,?,?,?,CURRENT_DATE )"), eq(new Object[]{transaction1.getTransactionFrom(), transaction1.getTransactionTo(), transaction1.getTransactionAmt(), transaction1.getTransactionStatus()}))).thenReturn(1);
        assertEquals("Transaction successful in DB",bankService.newPayment(transaction1));
    }

    //test to list payees -SOAP service
    @Test
    void listPayeesTest(){
        Payee payee1=new Payee(87,"Gourav",87654567L,2);
        Payee payee2=new Payee(88,"Abhihsek",765456L,2);
        Payee payee3=new Payee(89,"Kirthan",789L,2);
        Customer customer4 = new Customer(2, "Anusha", "Manglore", "inactive", 76545L, "anu", "anu12", 0);
        List<Payee> payeeList=Stream.of(payee1,payee2,payee3).collect(Collectors.toList());
        String username="anu";
        when(jdbcTemplate.query(eq("Select * from payee join customer on customer.customer_id = payee.customer_id where customer.username=? "),any(RowMapper.class),eq(username))).thenReturn(payeeList);
        assertEquals(payeeList,bankService.listPayee(username));
        assertNotEquals(payee1,bankService.listPayee(username).get(1));
    }

    //Login testing
    @Test
    void LoginTest(){
        Customer customer3 = new Customer(1, "Apoorva", "Banglore", "active", 234543L, "appu", "appu12", 1);
        Customer customer4 = new Customer(2, "Anusha", "Manglore", "inactive", 76545L, "anu", "anu12", 0);
        List<Customer> customerlist= Stream.of(customer3,customer4).collect(Collectors.toList());
        String username="appu",password="appu12";
        when(jdbcTemplate.queryForObject(eq("select * from CUSTOMER where username=?"),any(RowMapper.class),eq(username))).thenReturn(customer3);
        assertEquals(customer3.getUsername(),username);
        assertNotEquals(customer4,bankService.Login(username,password));
    }

    //test to get a customer object
    @Test
    void getCutomerByUsernameTest(){
        Customer customer1=new Customer(1,"Apoorva","Banglore","active",234543L,"appu","appu12",1);
        Customer customer2=new Customer(2,"Anusha","Manglore","inactive",76545L,"anu","anu12",0);
        Customer customer5=new Customer(2,"karthik","ballari","active",76545L,"karthi","karthi12",3);
        List<Customer> custlist=Stream.of(customer1,customer2,customer5).collect(Collectors.toList());
        String name="anu";
        when(jdbcTemplate.queryForObject(eq("select * from Customer where username=?"),any(RowMapper.class),eq(name))).thenReturn(customer2);
        assertEquals(customer2,bankService.getByUsername(name));
        assertFalse(bankService.getByUsername(name).equals(customer5));   //must pass
    }

    //test to list transcation
    @Test
    void ListTransactionsTest(){
        Transaction transaction1=new Transaction(9876,43239696L,06765L,7676.98f,"fail",new Date());
        Transaction transaction2=new Transaction(9876,076545L,0656L,86567.8f,"Succes",new Date());
        Transaction transaction3=new Transaction(8765,86543L,9654L,70876.98f,"Scuccess",new Date());
        List<Transaction> transactions=Stream.of(transaction1,transaction2,transaction3).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from transaction"),any(RowMapper.class))).thenReturn(transactions);
        assertEquals(transactions,bankService.allTransactions().subList(0,3));
        assertTrue(bankService.allTransactions().contains(transaction1));
    }
}
