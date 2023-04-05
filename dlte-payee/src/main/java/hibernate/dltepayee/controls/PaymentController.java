package hibernate.dltepayee.controls;

import hibernate.dltepayee.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hibernate.dltepayee.services.PaymentService;

import java.util.List;
import java.util.Optional;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/insert")
    public Payment callingSave(@RequestBody Payment payment) {
        return paymentService.implementationOfSave(payment);
    }

    @GetMapping("/view")
    public List<Payment> callingFindAll() {
        return paymentService.implementationOfFindAll();
    }

    @GetMapping("/details/{payeeId}")
    public Optional<Payment> callingFindbyId(@PathVariable("payeeId") int payeeId) {
        return paymentService.implentationOfFindbyId(payeeId);
    }

    @PutMapping("/modify/{payeeId}")
    public Payment callingUpdate(@RequestBody Payment payment) {
        return paymentService.implementationOfSave(payment);
    }

    @DeleteMapping("/delete/{payeeId}")
    public String callingDeletebyId(@PathVariable("payeeId") int payeeId) {
        return paymentService.implementationOfDeletebyId(payeeId);
    }

    @GetMapping("/upi")
    public List<Integer> callingFetchUpi() {
        return paymentService.implementFetchUpi();
    }

    @GetMapping("/payee/{ifscCode}")
    public List<String> callExactPayee(@PathVariable("ifscCode") String ifscCode) {
        return paymentService.implementFetchExactPayee(ifscCode);
    }

    @GetMapping("/all/{ifsc}")
    public List<Payment> callAllByIfsc(@PathVariable("ifsc") String ifsc){
        return paymentService.implementFetchAllByifscCode(ifsc);
    }

    @GetMapping("/update")
    public void callUpdateUpi(){
        paymentService.implementationUpdateUpi();
        return;
    }

    @GetMapping("/records/{upi}")
    public List<Payment> callGetRecords(@PathVariable("upi") Integer upi){
        return paymentService.implementationGetRecords(upi);
    }
}
