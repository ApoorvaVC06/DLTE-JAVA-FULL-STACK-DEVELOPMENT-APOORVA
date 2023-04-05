package review3;

import java.sql.SQLException;
import java.util.Scanner;


import java.util.InputMismatchException;

import static java.lang.System.exit;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        StudentImplements studentImplements = new StudentImplements();
        Student student = new Student();
        Address address = new Address();
        studentImplements.jdbcConnection();
        do {
            System.out.println("Enter the Operation to be Performed:\n 1. add new student details\n 2.Display the Students Details\n 3.Delete the student details \n 4.Exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Enter the Student Name, Register Number, Age, Email");
                    student.setName(scanner1.nextLine());
                    student.setRegister_number(scanner.nextInt());
                    student.setAge(scanner.nextInt());
                    student.setEmail(scanner1.nextLine());
                    System.out.println("Enter the student Address which includes(Locality, Area, city, Pin Code )");
                    address.setLocality(scanner1.nextLine());
                    address.setArea(scanner1.nextLine());
                    address.setCity(scanner1.nextLine());
                    address.setPin(scanner.nextInt());
                    studentImplements.insert(student, address);
                    break;
                case 2:
                    studentImplements.viewDetails();
                    break;
                case 3:
                    System.out.println("Enter the Student Register Number:");
                    studentImplements.delete(scanner.nextInt());
                    break;
                case 4:
                    exit(0);
                default:
                    System.out.println("Invalid Input");
            }

        }while (true);
    }
}
