package host;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CARD {
    private Long card_number;
    private String card_holder;
    private int card_pin,card_limit;
    private Date card_expiry;

}
