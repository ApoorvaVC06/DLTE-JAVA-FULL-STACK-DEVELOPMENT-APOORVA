package ojdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresses {
    private int addId;
    private int doorNo;
    private String Street;
    private String city;
    private Integer pin;
}
