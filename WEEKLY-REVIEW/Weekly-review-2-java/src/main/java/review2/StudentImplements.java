package review2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentImplements implements StudentInterface {
    ArrayList<Student> studentList = new ArrayList<>();
    File file = new File("C:\\DLTE-Full Stack Developer\\DLTE-JAVA\\File handling\\studentsfile.txt");

    public StudentImplements() throws IOException {
       // writeRecords(studentList);
    }
    @Override
    public void  writeRecords(ArrayList<Student> studentList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentList);
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Students details successfully registered in the file :"+file.getName());
    }
    public ArrayList<Student> readRecords() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (ArrayList<Student>) objectInputStream.readObject();
    }
}
