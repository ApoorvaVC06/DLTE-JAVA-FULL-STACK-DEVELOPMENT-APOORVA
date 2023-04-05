import dependency.Customer;
import dependency.DaoOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String Name=request.getParameter("name");
        String Email=request.getParameter("email");
        String Pan=request.getParameter("pan");
        int Contact=Integer.parseInt(request.getParameter("contact"));
        int Pin=Integer.parseInt(request.getParameter("pin"));
        Customer customer=new Customer();
        customer.setCustomerName(Name);
        customer.setCustomerEmail(Email);
        customer.setCustomerPan(Pan);
        customer.setCustomerContact(Contact);
        customer.setCustomerPin(Pin);




        try {
            DaoOperations daoOperations=new DaoOperations();
            daoOperations.insert(customer);
            logger.log(Level.INFO,"Information stored");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
