package hibernate.dltepayee.services;

import hibernate.dltepayee.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hibernate.dltepayee.remote.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    //CRUD operations
    public Payment implementationOfSave(Payment payment){
        return paymentRepository.save(payment);
    }
    public List<Payment> implementationOfFindAll(){ return (List<Payment>) paymentRepository.findAll();}
    public Optional<Payment> implentationOfFindbyId(int payeeId){ return paymentRepository.findById(payeeId);}

    public String implementationOfDeletebyId(int payeeId){
        Payment payment=paymentRepository.findById(payeeId).get();
        paymentRepository.deleteById(payeeId);
        String ack=payment.getPayeeName()+" has been removed from the table records";
        return ack;
    }

    //HQL--returns a list of all upi's
    public List<Integer> implementFetchUpi(){
        return paymentRepository.findAllUpi();
    }

    //HQL--returns a list of payee names with same ifsc code (those belong to same bank)
    public List<String> implementFetchExactPayee(String ifcsCode){
        return paymentRepository.findAllByIfscCode(ifcsCode);
    }

    //Exact(ByAttribute)--returns the object(all records) of payee's with provided ifsc code
    public List<Payment> implementFetchAllByifscCode(String ifsc){
        return paymentRepository.findAllByifscCode(ifsc);
    }

    //UPDATE- based on some logic
    public void implementationUpdateUpi(){ paymentRepository.updateUpi();return ;}

    //SQL--get records based on given upi
    public List<Payment> implementationGetRecords(Integer upi) {
        return paymentRepository.getRecordsOnUpi(upi);
    }
}
