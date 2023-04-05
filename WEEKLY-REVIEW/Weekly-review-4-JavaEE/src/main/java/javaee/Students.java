package javaee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Students {
    private int registerNumber;
    private String name;
    private int age;
    private String email;
}
