package banking;

import lombok.Data;

import java.util.*;

@Data
public class Student implements StudentDetails{
   List students=new ArrayList();
   private Integer reg_num;
    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setReg_num(Integer reg_num) {
        this.reg_num = reg_num;
    }

    private String email,address;

    public void Details() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Registration number:");
            setReg_num(scanner.nextInt());
            System.out.println("Enter name of the student:");
            setName(scanner.next());
            System.out.println("Enter Age of the student:");
            setAge(scanner.nextInt());
            System.out.println("Enter email id:");
            setEmail(scanner.next());
            System.out.println("Enter the permanent address");
            setAddress(scanner.next());
//            students.add();
//            students.add();
//            students.add(Age);
//            students.add(email);
//            students.add(adress);

        }
        catch (InputMismatchException ie){
            throw ie;
    } }

        @Override
        public void ViewDetails () {
            System.out.println(students);
            return;
        }
    }
