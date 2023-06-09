package bank.project.app.login;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class CustomerLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    Logger logger= LoggerFactory.getLogger(CustomerLoginSuccessHandler.class);
    @Autowired
    BankService bankService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
       Customer customer= (Customer) authentication.getPrincipal();
     ResourceBundle bundle=ResourceBundle.getBundle("Alphabank");

             bankService.getByUsername(customer.getUsername());
             logger.info("success");
             bankService.setAttempts(customer.getCustomer_id());
             int attempts=customer.getAttempts();
             logger.info(String.valueOf(attempts));
             bankService.resetStatus(customer.getCustomer_id());
             super.setDefaultTargetUrl("/web/dash");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
