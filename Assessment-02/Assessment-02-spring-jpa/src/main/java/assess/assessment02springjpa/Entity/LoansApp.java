package assess.assessment02springjpa.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoansApp {
    @Id
    private int loanReqNum;
    @NonNull
    private Double reqAmt;
    @NonNull
    private int cibil;
    @NonNull
    private long aadhar;
    @NonNull
    private String pan;
    @NonNull
    private String profession;
    @NonNull
    private Double income;
    @NonNull
    private String statusofApproval;
    @Temporal(TemporalType.DATE)
    private Date dateOfReq;


}
