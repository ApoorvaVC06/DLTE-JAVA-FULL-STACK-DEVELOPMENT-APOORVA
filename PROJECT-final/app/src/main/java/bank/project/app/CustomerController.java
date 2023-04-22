package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import bank.project.dao.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("rest")
@ComponentScan("bank.project.dao")
public class CustomerController {

    @Autowired
    private BankService bankService;
   ResourceBundle bundle=ResourceBundle.getBundle("Alphabank");

    private Logger logger=LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/")
    public List<Customer> callList(){
        logger.info("Controller about to print All the records");
        return bankService.listAll();
    }

    //to get the status of customer(used before adding security)
    @PostMapping("/byusername")
    public String callByUsername(@RequestParam("userName") String user, @RequestParam("passWord") String pass){
       String status= bankService.getByUsername(user).getCustomer_status();
       logger.info("Customer account status received");
       return status;}

   //authenicate user (without security)
    @PostMapping("/authenticate")
    public String login(@RequestParam("userName") String username,@RequestParam("passWord") String password) {
        logger.info("parameters received from page for "+username);
        return bankService.Login(username,password);     //get the whole object
    }

    //to get the username from login page to dashboard
    @GetMapping("/username")
    String getUserName(Principal principal){
        return principal.getName();
    }

   //url to make a new transaction
    @PostMapping("/insert")
    public String addTranscation(@RequestParam("Payeeacc") Long payeeaccno,@RequestParam("Accnum") Long accnum,@RequestParam("Amount") Float amount) throws ParseException {
       logger.info("Adding a new transcation ");
        Transaction transaction=new Transaction();
        transaction.setTransactionFrom(accnum);
        transaction.setTransactionTo(payeeaccno);
        transaction.setTransactionAmt(amount);
        transaction.setTransactionStatus("successful");
       // transaction.setTransactionDate(String.valueOf(date));
        //logger.info("trying to make a new payment");
        return bankService.newPayment(transaction);
    }

    //to list the tranactions of the logged customer
    @GetMapping("/list")
    public List<Transaction> list(){
        return bankService.allTransactions();
    }
}

