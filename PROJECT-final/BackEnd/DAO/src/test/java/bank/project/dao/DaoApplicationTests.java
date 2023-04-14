//package bank.project.dao;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.util.Optional;
//
////import static net.bytebuddy.matcher.ElementMatchers.any;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.lenient;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class DaoApplicationTests {
//    @Mock
//    JdbcTemplate jdbcTemplate;
//    @Mock
//    BankOperations bankOperations;
//    @Autowired
//    BankService bankService;
////    @Test
////    void contextLoads() {
////    }
//
//    @Test
//    void testGetByusername(){
//        Customer customer1=new Customer(1,"Apoorva","Banglore","active",234543L,"appu","appu12",1);
//        Customer customer2=new Customer(2,"Anusha","Manglore","inactive",76545L,"anu","anu12",0);
////        When(bankService.getByUsername("appu")).thenReturn(customer1);
//        ReflectionTestUtils.setField(bankService, "jdbcTemplate", jdbcTemplate);
//        lenient().when(jdbcTemplate.queryForObject(any(String.class),Customer.class)).thenReturn(customer1);
//        lenient().when(bankOperations.getByUsername("appu")).thenReturn(customer1);
//        assertEquals(customer1,bankService.getByUsername("appu"));
//    }
//}
