package payment;
import java.util.Scanner;

public class ConsoleGpay {
    public static void main(String[] args) {
        Gpay obj=new Gpay("Apoorva",123344L,9876,1000.0f);//constructor by passing parameters
        System.out.println(obj.getName()+" "+obj.getAccnum()+" "+obj.getUpi()+" "+obj.getAccbal());//using getters
        System.out.println(obj.toString());//calling by to string method
        //obj.fundtransfer();//calling methods
        //obj.recharge();
        obj.recharge("");
    }
}
//Gpay class includes getter and setter ,tostring method
class Gpay{
    private String name;
    private Long accnum;
    private Integer upi;
    private Float accbal;
    Scanner scanner=new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccnum() {
        return accnum;
    }

    public void setAccnum(Long accnum) {
        this.accnum = accnum;
    }

    public Integer getUpi() {
        return upi;
    }

    public void setUpi(Integer upi) {
        this.upi = upi;
    }

    public Float getAccbal() {
        return accbal;
    }

    public void setAccbal(Float accbal) {
        this.accbal = accbal;
    }

    public Gpay(String name,Long accnum,Integer upi,Float accbal){
        this.name=name;
        this.accnum=accnum;
        this.upi=upi;
        this.accbal=accbal;

    }


    @Override
    public String toString() {
        return "Gpay{" +
                "name='" + name + '\'' +
                ", accnum=" + accnum +
                ", upi=" + upi +
                ", accbal=" + accbal +
                '}';
    }
    //method to transfer the fund
    public void fundtransfer(){
        Integer Upi;
        System.out.println("enter name of the recipient");
        String reciver = scanner.nextLine();
        System.out.println("enter amount to be tranferred");
        Float amt = scanner.nextFloat();
        //check the accunt balance before proceeding to payment
        if(amt<=accbal){
            accbal-=amt;
            System.out.println("enter upi id");
            Upi = scanner.nextInt();

        if (Upi.equals(this.upi)) {
            System.out.println(amt+" is transferred to "+reciver+" Available balance is "+accbal);
        }
        else System.out.println("Invalid upi pin");
        }
        else{
            System.out.println("Current balance is not enough to make this payment");
        }
    }
    //method to recharge using method overriding concept
    public void recharge(){
        System.out.println("enter your mobile number:");
        Long number = scanner.nextLong();

        System.out.println("enter amount to be tranferred");
        Float amt = scanner.nextFloat();
        if(amt<=accbal){
            accbal-=amt;
            System.out.println("enter upi id");
            Integer Upi = scanner.nextInt();

            if (Upi.equals(this.upi)) {
                System.out.println("Recharge of "+amt+"is succesful!!  Available balance is "+accbal);
            }
            else System.out.println("Invalid upi pin");
        }
        else{
            System.out.println("Current balance is not enough to make this payment");
        }
    }

    //method to recharge  a FASTAG for vechile using concept of method overriding
    public void recharge(String number){
        System.out.println("enter your vehicle number:");
        number = scanner.nextLine();

        System.out.println("enter amount to be tranferred");
        Float amt = scanner.nextFloat();
        if(amt<=accbal){
            accbal-=amt;
            System.out.println("enter upi pin");
            Integer Upi = scanner.nextInt();

            if (Upi.equals(this.upi)) {
                System.out.println("Recharge of " +amt+" is Successfull for vechile No: " +number+" Available balance Rs " +accbal);
            }
            else System.out.println("Invalid upi pin");
        }
        else{
            System.out.println("Current balance is not enough to make this payment");
        }
    }
    }


