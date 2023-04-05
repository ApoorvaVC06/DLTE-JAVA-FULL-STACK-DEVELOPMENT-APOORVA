package hibernate.dltepayee;

import hibernate.dltepayee.model.Payment;
import hibernate.dltepayee.remote.PaymentRepository;
import hibernate.dltepayee.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class DltePayeeApplicationTests {

    @MockBean
    PaymentRepository paymentRepository;
    @Autowired
    PaymentService paymentService;

    @Test
    void testSave(){
        Payment payment1=new Payment(7,"Apoorva",987654156L,"SE47924",4751);
        Payment payment2=new Payment(8,"Mahesh", 8764567876L,"DR86426",9647);
        Payment payment3=new Payment(9,"Maggi", 97364563287L,"LH46827",6373);
        when(paymentRepository.save(payment1)).thenReturn(payment1);
        assertNotSame(payment1,paymentService.implementationOfSave(payment1));          //must fail
        assertEquals(payment2,paymentService.implementationOfSave(payment2));          //must pass but overall test fails

    }

    @Test
    void testView() {
        List<Payment> testData= Stream.of(new Payment(7,"Apoorva",987654156L,"SE47924",4751),new Payment(8,"Apoorva",
                987654156L,"SE47924",9647)).collect(Collectors.toList());

        when(paymentRepository.findAll()).thenReturn(testData);
        assertEquals(987654156L,paymentService.implementationOfFindAll().get(1).getAccNum());  //must pass
    }

    @Test
    void testDetails(){
        Optional<Payment> payment1=Optional.of(new Payment(7,"Apoorva",987654156L,"SE47924",4751));
        Optional<Payment> payment2=Optional.of(new Payment(8,"Mahesh", 8764567876L,"SE47924",9647));
        when(paymentRepository.findById(8)).thenReturn(payment2);
        assertNotEquals(payment1,paymentService.implentationOfFindbyId(8));     //must pass
    }

    @Test
    void testRecorsByUpi(){
        List<Payment> testData= Stream.of(new Payment(7,"Apoorva",987654156L,"SE47924",4751),
                new Payment(8,"Apoorva", 987654156L,"SE47924",9647),
                new Payment(9,"Maggi", 97364563287L,"LH46827",6373)).collect(Collectors.toList());
        when(paymentRepository.getRecordsOnUpi(4751)).thenReturn(testData);
        assertEquals("Apoorva",paymentService.implementationGetRecords(9647));      //must fail
       // assertNull("Apoorva", paymentService.implementationGetRecords(9647).get(1).getPayeeName()); //must pass
    }

    @Test
    void testGetNames(){
        List<String> list1=Stream.of("Razak","Sridhar","Manvith").collect(Collectors.toList());
        List<String> list2=Stream.of("Saikethan","Aishwarya","Apoorva").collect(Collectors.toList());
        when(paymentRepository.findAllByIfscCode("SE47924")).thenReturn(list1);
        assertNotEquals(list2,paymentService.implementFetchExactPayee("SE47924")); //must fail
    }

    @Test
    void testException(){
        assertThrows(IndexOutOfBoundsException.class,()->{
            paymentService.implentationOfFindbyId(10);      //expected exception so test fails
        });
    }

}
