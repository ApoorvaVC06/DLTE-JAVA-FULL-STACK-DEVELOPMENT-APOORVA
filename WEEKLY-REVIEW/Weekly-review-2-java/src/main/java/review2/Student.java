package review2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//POJO class/model class /business class
public class Student implements Serializable {
    private int registerNumber;
    private String name;
    private int age;
    private String email;
    private Address address;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Address implements Serializable{
    private String locality;
    private String area;
    private String city;
    private Integer pin;
}
