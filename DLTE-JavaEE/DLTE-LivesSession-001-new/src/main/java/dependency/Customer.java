package dependency;
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

    public Customer(int customerId, String customerName, String customerEmail, String customerPan, int customerContact, int customerPin) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPan = customerPan;
        this.customerContact = customerContact;
        this.customerPin = customerPin;
    }
}
