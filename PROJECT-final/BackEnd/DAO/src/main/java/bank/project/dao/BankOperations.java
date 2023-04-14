package bank.project.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface BankOperations {
    Customer getByUsername(String username);
    String Login(String username, String password);
    //void incrementFailedAttempts(int id);
//    int getAttempts(int id);
//    int decrementAttempts(int id);
//    void setAttempts(int id);
//    void updateStatus();
    List<Payee> getByCustId(int cust_id);
    String insert(Transaction transaction) throws ParseException;
    List<Transaction> allTransactions();    }
