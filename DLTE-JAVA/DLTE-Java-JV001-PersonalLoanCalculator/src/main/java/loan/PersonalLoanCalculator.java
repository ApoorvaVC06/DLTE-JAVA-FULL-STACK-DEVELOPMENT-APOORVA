package loan;
import java.util.Scanner;
public class PersonalLoanCalculator {
    public static void main(String[] args) {
        Integer amount=0, tenure=0; //Initializing the declared variables
        Double interest=0.0, Emi=0.0;

        //Read input from console (by creating an object and predefined scanner class)
        Scanner scannerobject=new Scanner(System.in);
        System.out.println("Enter the loan amount");
        amount=scannerobject.nextInt();
        System.out.println("Enter the interest rate");
        interest=scannerobject.nextDouble();
        interest=interest/(12*100);
        System.out.println("Enter the duration(in years)");
        tenure=scannerobject.nextInt();
        tenure=tenure*12;;

        //Calculation of EMI
        Emi= (amount*interest*Math.pow(1+interest,tenure))/(Math.pow(1+interest,tenure)-1);
        System.out.print("EMI is= "+Emi+"\n");

        //Calculation of total amount
        double totalamt = Emi*tenure;
        System.out.println(totalamt+" is the total amount" );

        //To repay  the amount
        System.out.println("Amount to be repayed is: "+(amount+totalamt));
    }
}
