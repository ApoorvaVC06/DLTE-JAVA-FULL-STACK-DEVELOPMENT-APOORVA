package bank.project.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DaoApplication.class, args);
//        BankService bankService=new BankService();
//        System.out.println(bankService.listAll());
//        System.out.println(bankService.getByUsername("karthi","karthi12"));
   }

}
