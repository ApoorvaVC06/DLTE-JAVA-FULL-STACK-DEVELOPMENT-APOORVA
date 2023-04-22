package bank.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

//transaction POJO
public class Transaction {
    private int transactionId;
    private Long transactionFrom;
    private Long transactionTo;
    private float transactionAmt;
    private String transactionStatus;
    private Date transactionDate;

}
