package banking;

import lombok.Data;
import java.io.Serializable;

@Data
public class Ticket implements Serializable {
    private String ticket_id, issue, card_number,date, status;


    public Ticket(String ticket_id, String issue, String card_number, String status, String date) {
        this.ticket_id = ticket_id;
        this.issue = issue;
        this.card_number = card_number;
        this.status = status;
        this.date = date;
    }
}
