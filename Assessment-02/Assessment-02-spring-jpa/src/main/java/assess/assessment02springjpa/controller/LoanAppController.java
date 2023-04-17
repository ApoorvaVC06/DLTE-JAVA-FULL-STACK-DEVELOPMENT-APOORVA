package assess.assessment02springjpa.controller;

import assess.assessment02springjpa.Entity.LoansApp;
import assess.assessment02springjpa.service.LoansAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LoanAppController {
    @Autowired
    LoansAppService loansAppService;
    @PostMapping("/insert")
    public LoansApp LoansAppcallingSave(@RequestBody LoansApp loansApp) {
        return loansAppService.implementationOfSave(loansApp);
    }
    @PutMapping("/update")
    public LoansApp LoansAppcallingUpdate(@RequestBody LoansApp loansApp){
        return loansAppService.implementUpdateStatus(loansApp);
    }
    @PutMapping("/reject")
    public LoansApp LoansAppcallingUpdateReject(@RequestBody LoansApp loansApp){
        return loansAppService.implementupdateReject(loansApp);
    }
    @GetMapping("/rejected")
    public List<LoansApp> LoanAppcallingLIist(@PathVariable String status)
}
