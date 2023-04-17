//package bank.project.dao;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
////import static net.bytebuddy.matcher.ElementMatchers.any;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.lenient;
//import static org.mockito.Mockito.when;
//@SpringBootTest
//class DaoApplicationTests {
//    @Mock
//    JdbcTemplate jdbcTemplate;
//    @Mock
//    BankOperations bankOperations;
//    @InjectMocks
//    BankService bankService;
////    @Test
////    void contextLoads() {
////    }
//
//    @Test
//    void testGetByusername(){
//        Customer customer1=new Customer(1,"Apoorva","Banglore","active",234543L,"appu","appu12",1);
//        Customer customer2=new Customer(2,"Anusha","Manglore","inactive",76545L,"anu","anu12",0);
//        Customer customer5=new Customer(2,"karthik","ballari","active",76545L,"karthi","karthi12",3);
//            List<Customer> custlist=Stream.of(customer1,customer2,customer5).collect(Collectors.toList());
//            String username="anu",password;
//        when(jdbcTemplate.query(eq("select * from customer where username=?"), eq(new BankService.CustomersMapper(){username}))).thenReturn(custlist);
//            Customer c=custlist.get(2);
//            assertEquals(customer2,bankOperations.getByUsername(username));
//    }
//
//    @Test
//        void testinsert() throws ParseException {
//        Customer customer3 = new Customer(1, "Apoorva", "Banglore", "active", 234543L, "appu", "appu12", 1);
//        Customer customer4 = new Customer(2, "Anusha", "Manglore", "inactive", 76545L, "anu", "anu12", 0);
//        Transaction transaction1=new Transaction(9876,43239696L,06765L,7676.98f,"fail",new Date());
//        Transaction transaction2=new Transaction(9876,076545L,0656L,86567.8f,"Succes",new Date());
//
////        SimpleDateFormat fmt=new SimpleDateFormat("dd-MM-yyyy");
////        Date date = fmt.parse(transaction1.getTransactionDate());
//
//        when(jdbcTemplate.update(eq("insert into transaction values(?,?,?,?,?)"), eq(new Object[]{transaction1.getTransactionId(),transaction1.getTransactionFrom(),transaction1.getTransactionTo(),transaction1.getTransactionAmt(),transaction1.getTransactionStatus(),new Date()}))).thenReturn(1);
//               String result=bankService.insert(transaction1);
//               assertEquals("fail",result);
//    }
//
//
//    @Test
//    void testLogin(){
//        Customer customer3 = new Customer(1, "Apoorva", "Banglore", "active", 234543L, "appu", "appu12", 1);
//        Customer customer4 = new Customer(2, "Anusha", "Manglore", "inactive", 76545L, "anu", "anu12", 0);
//        List<Customer> customerlist= Stream.of(customer3,customer4).collect(Collectors.toList());
//        String username="appu",password="appu12";
//        when(jdbcTemplate.queryForObject(eq("select * from CUSTOMER where username=?"),eq(new BankService.CustomersMapper()))).thenReturn(customer3);
//        String status=bankOperations.Login(username,password);
//        assertEquals("success",status);
//    }
//
//
//}
