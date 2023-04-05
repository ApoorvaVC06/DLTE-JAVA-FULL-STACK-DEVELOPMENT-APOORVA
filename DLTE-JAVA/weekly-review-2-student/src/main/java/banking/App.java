package banking;

import java.io.*;
import java.util.*;
public class App implements StudentRemote
{
    List<Student> information=new ArrayList();

    @Override
    public void AddDetails() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration number");
        Long reg_num = scanner.nextLong();
        if (information.contains(reg_num)) {
            System.out.println("Student is already registered.Please enter another reg number");
            reg_num = scanner.nextLong();
        }
        student.setReg_num(reg_num);
        System.out.println("Enter the contact number");
        student.setContact(scanner.nextLong());
        System.out.println("Enter name");
        student.setName(scanner.next());
        System.out.println("Enter age");
        student.setAge(scanner.nextInt());
        System.out.println("Enter email");
        student.setEmail(scanner.next());
        System.out.println("Enter the address (Street,City,State,pinCode):");
        student.setStreet(scanner.next());
        student.setCity(scanner.next());
        student.setState(scanner.next());
        student.setPincode(scanner.nextInt());
        information.add(student);
        System.out.println("details entered");
        return;}
    @Override
    public List<Student> ViewDetails() {
        System.out.println("The information you require is:");
        return information;
    }
    File file=new File("C:\\DLTE-Full Stack Developer\\DLTE-JAVA\\File handling\\studentsfile.txt");
    private  FileInputStream fis=null;
    private FileOutputStream fos=null;
    private ObjectInputStream ois=null;
    private ObjectOutputStream oos=null;
     private ArrayList buffer;

     public List readrecords() throws IOException, ClassNotFoundException {
        fis=new FileInputStream(file);
        ois=new ObjectInputStream(fis);
        buffer = (ArrayList)ois.readObject();
        ois.close();
        fis.close();
        return  buffer;
    }

    public void writerecords(Collection information) throws IOException {

        try {
            fos=new FileOutputStream(file);
            oos= new ObjectOutputStream(fos);
           oos.writeObject(information);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }}
        public App() throws IOException {
        // writerecords(information);
        }


    public static void main( String[] args ) throws IOException, ClassNotFoundException,FileNotFoundException {
        App app=new App();
        Scanner scan=new Scanner(System.in);
        System.out.println("Welcome to school");
        while(true){
        System.out.println("Enter your choice\n 1.Add student details\n 2.View details \n 3.exit");
        switch (scan.nextInt()) {
            case 1:
                app.AddDetails();
                app.writerecords(app.information);
                break;
            case 2:
                app.ViewDetails();
                System.out.println(app.readrecords());
                break;
            case 3:
                exit();
                break;
        }
        }
    }
    private static void exit() {
        return;
    }
}
