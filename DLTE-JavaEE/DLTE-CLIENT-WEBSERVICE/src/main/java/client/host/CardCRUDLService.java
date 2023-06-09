
package client.host;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "cardCRUDLService", targetNamespace = "http://host/", wsdlLocation = "http://localhost:8082/crudl?wsdl")
public class CardCRUDLService
    extends Service
{

    private final static URL CARDCRUDLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CARDCRUDLSERVICE_EXCEPTION;
    private final static QName CARDCRUDLSERVICE_QNAME = new QName("http://host/", "cardCRUDLService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8082/crudl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CARDCRUDLSERVICE_WSDL_LOCATION = url;
        CARDCRUDLSERVICE_EXCEPTION = e;
    }

    public CardCRUDLService() {
        super(__getWsdlLocation(), CARDCRUDLSERVICE_QNAME);
    }

    public CardCRUDLService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CARDCRUDLSERVICE_QNAME, features);
    }

    public CardCRUDLService(URL wsdlLocation) {
        super(wsdlLocation, CARDCRUDLSERVICE_QNAME);
    }

    public CardCRUDLService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CARDCRUDLSERVICE_QNAME, features);
    }

    public CardCRUDLService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CardCRUDLService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CardCRUDL
     */
    @WebEndpoint(name = "cardCRUDLPort")
    public CardCRUDL getCardCRUDLPort() {
        return super.getPort(new QName("http://host/", "cardCRUDLPort"), CardCRUDL.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CardCRUDL
     */
    @WebEndpoint(name = "cardCRUDLPort")
    public CardCRUDL getCardCRUDLPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://host/", "cardCRUDLPort"), CardCRUDL.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CARDCRUDLSERVICE_EXCEPTION!= null) {
            throw CARDCRUDLSERVICE_EXCEPTION;
        }
        return CARDCRUDLSERVICE_WSDL_LOCATION;
    }

}
