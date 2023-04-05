package banking;

import java.util.Scanner;

public class DataEntry {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Student student = new Student();
        student.name="Apoorva";
        student.age=21;
        student.show();
    }
}
