package livesession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPan;
    private int customerContact;
    private int customerPin;
    List<Loan> myloans=new ArrayList<>();
}
