//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.16 at 12:06:10 PM PDT 
//


package bank.project.app.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for payee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="payeeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="payeeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="payeeAccNum" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payee", propOrder = {
    "payeeId",
    "payeeName",
    "payeeAccNum",
    "customerId"
})
public class Payee {

    protected int payeeId;
    @XmlElement(required = true)
    protected String payeeName;
    protected long payeeAccNum;
    protected int customerId;

    /**
     * Gets the value of the payeeId property.
     * 
     */
    public int getPayeeId() {
        return payeeId;
    }

    /**
     * Sets the value of the payeeId property.
     * 
     */
    public void setPayeeId(int value) {
        this.payeeId = value;
    }

    /**
     * Gets the value of the payeeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayeeName() {
        return payeeName;
    }

    /**
     * Sets the value of the payeeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayeeName(String value) {
        this.payeeName = value;
    }

    /**
     * Gets the value of the payeeAccNum property.
     * 
     */
    public long getPayeeAccNum() {
        return payeeAccNum;
    }

    /**
     * Sets the value of the payeeAccNum property.
     * 
     */
    public void setPayeeAccNum(long value) {
        this.payeeAccNum = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     */
    public void setCustomerId(int value) {
        this.customerId = value;
    }

}
