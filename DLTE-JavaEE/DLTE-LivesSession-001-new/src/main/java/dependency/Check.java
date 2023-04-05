package dependency;

import java.sql.SQLException;
import java.util.Scanner;

public class Check {


    public static void main(String[] args) throws SQLException {
        DaoOperations daoOperations=new DaoOperations();
        Customer customer=new Customer(123,"asds","wedre","wecf",2345,12);
        Loan loan;
        //daoOperations.insert(customer);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter customer_id:");
        System.out.println( daoOperations.fetch(scanner.nextInt()));
         System.out.println("fetched");
    }
}
