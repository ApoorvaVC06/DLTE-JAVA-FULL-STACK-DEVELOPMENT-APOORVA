package banking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Student implements Serializable {
    private Long reg_num,contact;
    private int pincode, age;
    private String name, email, address,Street,city,state;
}


