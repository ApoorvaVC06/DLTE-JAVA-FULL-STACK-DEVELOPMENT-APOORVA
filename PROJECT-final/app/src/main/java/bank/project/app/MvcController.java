package bank.project.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")

public class MvcController {
    @GetMapping("/login")
    public String login(){
        return "login";
}

    @GetMapping("/land")
    public String landingPage(){return "Landing";}

    @GetMapping("/dash")
    public String dashboardPage(){return "Dashboard";}

    @GetMapping("/pay")
    public String Payment(){return "Payment";}

    @GetMapping("/add")
    public String addPayee(){return "addPayee";}

    @GetMapping("/update")
    public String update(){return "update";}}

