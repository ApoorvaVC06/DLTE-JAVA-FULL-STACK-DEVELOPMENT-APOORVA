package bank.project.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")

public class MvcController {
    //url for login page
    @GetMapping("/login")
    public String login(){
        return "login";
}

    //url for landing page
    @GetMapping("/land")
    public String landingPage(){return "Landing";}

    //url for dashboard page
    @GetMapping("/dash")
    public String dashboardPage(){return "Dashboard";}

    //url for transaction page
    @GetMapping("/pay")
    public String Payment(){return "Payment";}

    //url for adding a new page
    @GetMapping("/add")
    public String addPayee(){return "addPayee";}

    //url for updatina a existing payee page
    @GetMapping("/update")
    public String update(){return "update";}}

