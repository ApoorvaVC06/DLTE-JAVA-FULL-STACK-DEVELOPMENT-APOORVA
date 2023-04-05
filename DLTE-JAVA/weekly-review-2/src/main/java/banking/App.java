package banking;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        Scanner scan=new Scanner(System.in);
        Student student=new Student();
        File file=new File("file2.txt");
        file.createNewFile();
        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);
        FileOutputStream fos=new FileOutputStream(file);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        try {
            System.out.println("choose 1.to Register a new student\n 2.To view the details of a student");
            Integer option = scan.nextInt();
            switch (option) {
                case 1:
                    student.Details();
                case 2:
                    student.ViewDetails();
            }
        }
        catch(InputMismatchException ie){}
        public TreeMap<String,Student> getrecords(Student.){
            file.list();
        }
        public void writerecords(){

        }
    }
    }
