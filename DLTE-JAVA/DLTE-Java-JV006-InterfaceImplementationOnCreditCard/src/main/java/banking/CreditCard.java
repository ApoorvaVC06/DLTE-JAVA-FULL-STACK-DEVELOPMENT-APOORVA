package banking;

import java.util.Scanner;
import java.util.Arrays;
//class implementing interface
public class CreditCard implements CreditMethods {
    Double[] bills = new Double[5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreditCard creditcard = new CreditCard();  //object-creation

        System.out.println("Enter the credit card bills");
        for (Integer index = 0; index < creditcard.bills.length; index++) {  //enter the credit card bills into an array of type Double
            creditcard.bills[index] = scanner.nextDouble();
        }
        System.out.println("What are you looking for?\n" + "1. Add new Card payment amount\n" +
                "2. Reduce the card bill\n" +
                "3. Update new bill by GST of 18% in every bills\n" +
                "4. Search and add GST 3% if bill amount is more than 30000 additionally\n" +
                "5. Sort and List bills");
        Integer value = scanner.nextInt();
        switch (value) {
            case 1:
                creditcard.NewCardEntry();break;
            case 2:
                creditcard.BillUpdate();break;
            case 3:
                creditcard.AddGST();break;
            case 4:
                creditcard.SearchAddGST();break;
            case 5:
                creditcard.SortListBills();break;

        }
        scanner.close();
    }

    //abstract method implementation
    public void NewCardEntry() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter the new credit card bill");
        Double newbill = scan1.nextDouble();
        bills = Arrays.copyOf(bills, bills.length + 1);
        bills[bills.length - 1] = newbill;
        System.out.println("Added the new Credit card bill");
        System.out.println("Credit card bills : " + Arrays.toString(bills)); //display the new array f bills
        scan1.close();
    }

    public void BillUpdate() {
        System.out.println("Enter the position of credit card bill in the array: ");
        Scanner scan2 = new Scanner(System.in);
        //Integer newbill = scan2.nextInt();
        bills[scan2.nextInt() - 1] = 0.0;
        System.out.println("Updated the credit card bill Successfully!!" + Arrays.toString(bills));
        scan2.close();
    }

    public void AddGST() {
        for (Integer index = 0; index < bills.length; index++) {
            bills[index] +=( bills[index] * 0.18);   //Add 18% GST
        }
        System.out.println("New credit card bills including GST " + Arrays.toString(bills));
    }

    public void SearchAddGST() {
        for (int index = 0; index < bills.length; index++) {
            if (bills[index] >= 30000)
                bills[index] += bills[index] * 0.03;
        }
        System.out.println("Added 3% GST for all the bills greater than 30000");
        System.out.println("Credit card bills : " + Arrays.toString(bills));
    }

    public void SortListBills() {
        Arrays.sort(bills);
        System.out.println("the Sorted Credit Card bills: " + Arrays.toString(bills));
    }
}
//interface with methods
interface CreditMethods {
    void NewCardEntry();        //Non-Static abstract methods

    void BillUpdate();

    void AddGST();

    void SearchAddGST();

    void SortListBills();
}
