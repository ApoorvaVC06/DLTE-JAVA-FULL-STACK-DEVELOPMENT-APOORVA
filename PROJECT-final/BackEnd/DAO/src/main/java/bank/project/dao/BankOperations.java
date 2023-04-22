package bank.project.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

//Interface including the methods
public interface BankOperations {
    Customer getByUsername(String username);
    String Login(String username, String password);
    List<Payee> listPayee(String username);
    String newPayment(Transaction transaction) throws ParseException;
    List<Transaction> allTransactions();    }

