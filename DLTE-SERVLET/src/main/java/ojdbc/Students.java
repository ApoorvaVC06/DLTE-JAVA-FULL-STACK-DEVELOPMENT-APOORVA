package ojdbc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Students {
    private int registerNumber;
    private String name;
    private int age;
    private String email;
   // private Adresses address;
}
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
////class Adresses implements Serializable {
////    private int addId;
////    private int doorNo;
////    private String Street;
////    private String city;
////    private Integer pin;
////}


