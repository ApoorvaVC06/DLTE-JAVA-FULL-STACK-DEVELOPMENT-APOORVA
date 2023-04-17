package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import bank.project.dao.Payee;
import bank.project.dao.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
@RequestMapping("rest")
@ComponentScan("bank.project.dao")


public class CustomerController {

    @Autowired
    private BankService bankService;
   ResourceBundle bundle=ResourceBundle.getBundle("Alphabank");

    private Logger logger=LoggerFactory.getLogger(CustomerController.class);

//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @PostMapping("/signup")
//    public String signup(@RequestBody Customer customer){
//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        return bankService.getByUsername(customer);
//    }
    @GetMapping("/")
    public List<Customer> callList(){
        logger.info("Controller about to print All the records");
        return bankService.listAll();
    }

    //to get the status of customer
    @PostMapping("/byusername")
    public String callByUsername(@RequestParam("userName") String user, @RequestParam("passWord") String pass){
       String status= bankService.getByUsername(user).getCustomer_status();
       logger.info("Customer account status received");
       return status;}
//     @GetMapping("/byid/{int id}")
//     public int callgetattemts(@PathVariable("id") int id){
//        return bankService.getAttempts(id);
//     }
    //to validate the customer

    @PostMapping("/authenticate")
    public String login(@RequestParam("userName") String username,@RequestParam("passWord") String password) {
        logger.info("parameters received from page for "+username);
        return bankService.Login(username,password);     //get the whole object
    }

//    @GetMapping("/payee/{custId}")
//    public List<Payee> callgetPayee(@PathVariable("custId") int custId){
//        return bankService.getByCustId(custId);
//    }

//    @PostMapping("/insert")
//    public String addTranscation(@RequestBody Transaction transaction) throws ParseException {
//        logger.info("trying to insert");
//        System.out.println(transaction);
////        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
////        Date date = fmt.parse(transaction.getTransactionDate());
////        System.out.println(date);
//        return bankService.insert(transaction);
//    }

    @PostMapping("/insert")
    public String addTranscation(@RequestParam("Payeeacc") Long payeeaccno,@RequestParam("Accnum") Long accnum,@RequestParam("Amount") Float amount) throws ParseException {
       logger.info("in rest controller inside trans insert ");
        Transaction transaction=new Transaction();
        transaction.setTransactionFrom(accnum);
        transaction.setTransactionTo(payeeaccno);
        transaction.setTransactionAmt(amount);
        transaction.setTransactionStatus("successful");
       // transaction.setTransactionDate(String.valueOf(date));
        logger.info("trying to insert");
        return bankService.insert(transaction);
    }

    @GetMapping("/list")
    public List<Transaction> list(){
        return bankService.allTransactions();
    }
}

