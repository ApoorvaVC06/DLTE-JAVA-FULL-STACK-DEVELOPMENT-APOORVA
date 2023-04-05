
package client.host;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for card complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="card">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="card_expiry" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="card_holder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="card_limit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="card_number" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="card_pin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "card", propOrder = {
    "cardExpiry",
    "cardHolder",
    "cardLimit",
    "cardNumber",
    "cardPin"
})
public class Card {

    @XmlElement(name = "card_expiry")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cardExpiry;
    @XmlElement(name = "card_holder")
    protected String cardHolder;
    @XmlElement(name = "card_limit")
    protected int cardLimit;
    @XmlElement(name = "card_number")
    protected Long cardNumber;
    @XmlElement(name = "card_pin")
    protected int cardPin;

    /**
     * Gets the value of the cardExpiry property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCardExpiry() {
        return cardExpiry;
    }

    /**
     * Sets the value of the cardExpiry property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCardExpiry(XMLGregorianCalendar value) {
        this.cardExpiry = value;
    }

    /**
     * Gets the value of the cardHolder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * Sets the value of the cardHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardHolder(String value) {
        this.cardHolder = value;
    }

    /**
     * Gets the value of the cardLimit property.
     * 
     */
    public int getCardLimit() {
        return cardLimit;
    }

    /**
     * Sets the value of the cardLimit property.
     * 
     */
    public void setCardLimit(int value) {
        this.cardLimit = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCardNumber(Long value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the cardPin property.
     * 
     */
    public int getCardPin() {
        return cardPin;
    }

    /**
     * Sets the value of the cardPin property.
     * 
     */
    public void setCardPin(int value) {
        this.cardPin = value;
    }

}
