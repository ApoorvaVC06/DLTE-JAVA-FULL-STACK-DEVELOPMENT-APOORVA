package banking;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

public class Sms extends Transaction{       //child class extending the properties of Transaction class
    public static void main(String[] args) {
        Sms sms=new Sms();
        sms.query();//qerry methods calls both the below methods internally
        //smSbanking.balanceenquiry();//call the balanceenquire method of child class-Transaction
        //smSbanking.rechargemobile();//call the rechargemobile method of child class-Transaction
        sms.Bookticket();//call the Bookticket method of child class-Transaction
    }
    public void query() {   //method to perform balance enquiry and recharge
        System.out.println("Enter 1901 for balance enquiry \n 2245 for recharge");
        Integer num = scanner.nextInt();
        Sms sms=new Sms();
        if (num == 1901) {
            sms.balanceenquiry();
        }
        else if(num==2245){
            sms.rechargemobile();
        }
        else System.out.println("Entered number doesnt match");
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
//parent class
class Kyc{
    private String accholder;
    private Long accnum;
    private Double accbalance=1000.09;
    private Integer upi=6767;

    public Integer getUpi() {
        return upi;
    }

    public Double getAccbalance() {
        return accbalance;
    }

    public void setAccbalance(Double accbalance) {
        this.accbalance = accbalance;
    }

    public String getAccholder() {
        return accholder;
    }
}
//child class extending the properties of Kyc class
class Transaction extends Kyc{
    Integer Upi;
    Double amt;
    Scanner scanner=new Scanner(System.in);

    //method for account blance enquiry
    public void balanceenquiry(){
        System.out.println("Enter Acc holder name and upi pin");
        String name=scanner.nextLine();
        Upi=scanner.nextInt();
        if (Upi.equals(getUpi())) {      //upi validation
            System.out.println("Available balance is "+getAccbalance());
        }
        else System.out.println("Invalid upi pin");
    }
    //method to recharge mobile phone
    public void rechargemobile(){
        System.out.println("enter your mobile number:");
        Long number = scanner.nextLong();
        System.out.println("enter amount to be tranferred");
        amt = scanner.nextDouble();
        if(amt<=getAccbalance()){   //check for balance before making payment
            setAccbalance((getAccbalance()-amt));
            System.out.println("enter upi id");
            Upi = scanner.nextInt();

            if (Upi.equals(getUpi())) {         //upi validation
                System.out.println("Recharge of "+amt+"is succesful!!  Available balance is "+getAccbalance());
            }
            else System.out.println("Invalid upi pin");
        }
        else{
            System.out.println("Current balance is not enough to make this payment");
        }
    }
    //method for booking online tickets
    public void Bookticket(){
        System.out.println("Ticket booking:\nEnter the number of seats to be booked:");
        Double seats=scanner.nextDouble();//1 seat costs 100rs
        System.out.println("enter upi id");
        Upi = scanner.nextInt();
        if((seats*100)<=getAccbalance()){     //check for balance before making payment
            if (Upi.equals(getUpi())) {          //upi validation
                setAccbalance(getAccbalance()-(seats*100));
                System.out.println(seats+" Seats are booked with "+(seats*100)+"rs. Available balance is "+getAccbalance());
            }
            else System.out.println("Invalid upi pin");}
        else System.out.println("Current balance is not enough to make this payment");
    }
}


