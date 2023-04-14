package bank.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payee {
    private int payeeId;
    private String payeeName;
    private Long payeeAccNum;
    private int customerId;
}