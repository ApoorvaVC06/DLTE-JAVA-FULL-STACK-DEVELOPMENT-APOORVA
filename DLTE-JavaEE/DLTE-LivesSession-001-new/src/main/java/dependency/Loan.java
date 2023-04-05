package dependency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private int loanNumber;
    private String borrowerName;
    private String loanType;
    private Double loanAmount;
    private Date issueDate;
}
