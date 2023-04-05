package review4;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Students {
    private int registerNumber;
    private String name;
    private int age;
    private String email;
    private List<Adresses> myaddress=new ArrayList<>();

   public Students(int registerNumber, String name, int age, String email) {
        this.registerNumber = registerNumber;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
