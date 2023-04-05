package banking;

import java.util.Scanner;

public class LoanRequest {
    public static void main(String[] args) {
        Encapsulatedclass customer=new Encapsulatedclass("Apoorva","ES8982P",687979799l,"doctor",557,638765412L);
        System.out.println(customer.toString());
        customer.loanSanction();

    }
}
//encapsulated calss with private data members and public member methods
class Encapsulatedclass{
    private String CustomerName;
    private String PAN;
    private Long Aadhar;
    private String profession;
    private Integer cibil;
    private Long contact;
    Scanner scanner=new Scanner(System.in);
    //getters and setters
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public Long getAadhar() {
        return Aadhar;
    }

    public void setAadhar(Long aadhar) {
        Aadhar = aadhar;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getCibil() {
        return cibil;
    }

    public void setCibil(Integer cibil) {
        this.cibil = cibil;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }
    //using to String method
    @Override
    public String toString() {
        return "Encapsulatedclass{" +
                "CustomerName='" + CustomerName + '\'' +
                ", PAN='" + PAN + '\'' +
                ", Aadhar=" + Aadhar +
                ", profession='" + profession + '\'' +
                ", cibil=" + cibil +
                ", contact=" + contact +
                '}';
    }
    //parameterized constructors
    public Encapsulatedclass(String customerName, String Pan,Long aadhar,String Profession,Integer Cibil,Long Contact){
        CustomerName=customerName;
        PAN=Pan;
        Aadhar=aadhar;
        profession=Profession;
        cibil=Cibil;
        contact=Contact;
    }
    //this method defines , weather to provide a loan(how much) to a customer based on his/her cibil score
    public void loanSanction(){
        System.out.println("Enter the Customer name ,PAN No , Aadhar No, His /Her Proffession ,contact ");
        setCustomerName(scanner.nextLine());
        setPAN(scanner.next());
        setAadhar(scanner.nextLong());
        setProfession(scanner.next());
        setContact(scanner.nextLong());
        System.out.println("enter the Cibil Score: ");
        setCibil(scanner.nextInt());
        if(getCibil()>=550 && getCibil()<=600)
            System.out.println(getCustomerName()+" is Eligible to get a Loan amount of  Rs 500000 at SBI,ICICI for profession  "+getProfession());
        else if(getCibil()>=661 && getCibil()<=700)
            System.out.println(getCustomerName()+" is Eligible to get a Loan amount of  Rs 1000000 at CANERA BANK,AXIS BANK, MUTHOOT fINANCE for profession "+getProfession());
        else if(getCibil()>=701)
            System.out.println(getCustomerName()+" is Eligible to get a Loan amount of  Rs 2300000 at UNION BANK, KARNATAKA BANK for profession "+getProfession());
        else System.out.println(getCustomerName()+" is not Enigible to get the loan from any of the banks");
    }
}
