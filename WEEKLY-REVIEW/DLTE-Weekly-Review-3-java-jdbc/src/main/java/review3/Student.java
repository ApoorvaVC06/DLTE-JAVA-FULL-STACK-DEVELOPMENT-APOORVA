package review3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int register_number;
    private String name;
    private int age;
    private String email;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Address{
    private String locality;
    private String area;
    private String city;
    private Integer pin;
}
