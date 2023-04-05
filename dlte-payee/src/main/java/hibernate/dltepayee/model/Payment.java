package hibernate.dltepayee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int payeeId;
    @NonNull
    private String payeeName;
   @NonNull
    private long accNum;
    @NonNull
    private String ifscCode;
//    @NonNull
//    private int contact;
    @NonNull
    private int upi;
}
