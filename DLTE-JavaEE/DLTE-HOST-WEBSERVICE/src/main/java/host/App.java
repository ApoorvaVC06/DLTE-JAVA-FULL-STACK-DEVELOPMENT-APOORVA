package host;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 *
 */
public class App 
{

        private static String url="http://localhost:8082/crudl";
        public static void main(String[] args) {
        cardCRUDL cardcrudl=new cardCRUDL();
        System.out.println("Webservice is running on "+url);
        Endpoint.publish(url,cardcrudl);
    }
}
