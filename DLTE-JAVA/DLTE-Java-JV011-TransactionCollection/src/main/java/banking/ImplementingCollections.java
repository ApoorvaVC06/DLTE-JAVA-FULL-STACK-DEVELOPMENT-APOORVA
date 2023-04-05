package banking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class ImplementingCollections {
    public static void main(String[] args) {

    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Transaction{
    private  Long TransID;
    private String TransType;
    private String TransMode;
    private Double TransAmt;
    private Date TransDate;

    public void AddTransaction(){

    }

}
