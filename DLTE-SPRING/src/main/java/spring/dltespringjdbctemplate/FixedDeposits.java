package spring.dltespringjdbctemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedDeposits {
    private Integer deposite_id,deposite_tenure;
    private Double deposite_amt,mature_amt;
    private Date deposite_date,mature_date;
    private String mode_of_div;
    private Float interest_rate;
}
