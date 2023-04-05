package banking;

import lombok.Data;

import java.util.Date;
@Data
public class Card {
    private Long card_number;
    private String card_holder;
    private Integer card_pin;
    private Date card_expiry;
    private Integer  card_limit;

    public Long getCard_number() {
        return card_number;
    }

    public void setCard_number(Long card_number) {
        this.card_number = card_number;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public Integer getCard_pin() {
        return card_pin;
    }

    public void setCard_pin(Integer card_pin) {
        this.card_pin = card_pin;
    }

    public Date getCard_expiry() {
        return card_expiry;
    }

    public void setCard_expiry(Date card_expiry) {
        this.card_expiry = card_expiry;
    }

    public Integer getCard_limit() {
        return card_limit;
    }

    public void setCard_limit(Integer card_limit) {
        this.card_limit = card_limit;
    }
}
