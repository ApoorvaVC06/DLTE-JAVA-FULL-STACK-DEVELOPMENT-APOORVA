//package bank.project.app;
//
//import bank.project.dao.BankService;
//import bank.project.dao.Transaction;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.text.ParseException;
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class AppApplicationTests {
//@Autowired
//    BankService bankService;
//@Autowired
//    CustomerController customerController;
////    @Test
////    void contextLoads() {
////    }
//   @Test
//    void addTranscationTest() throws ParseException {
//       Transaction transaction=new Transaction(7654567,98765456L,876764567L,876.987f,"failed",new Date());
//        //customerController.addTranscation(98765456L,876764567L,876.987f);
//        when(customerController.addTranscation(98765456L,876764567L,876.987f)).thenReturn("Transaction successful");
//        //assertEquals
//       assertEquals("Transction successful",customerController.addTranscation(98765456L,876764567L,876.987f));
//   }
//}
