package assess.assessment02springjpa.service;

import assess.assessment02springjpa.Entity.LoansApp;
import assess.assessment02springjpa.repository.LoansAppRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoansAppService {
    @Autowired
    LoansAppRepo loansAppRepo;
    public LoansApp implementationOfSave(LoansApp loansApp){
        return loansAppRepo.save(loansApp);
    }

    public LoansApp implementUpdateStatus(LoansApp loansApp){
         return loansAppRepo.updatestatus(loansApp);
    }
    public LoansApp implementupdateReject(LoansApp loansApp){
        return loansAppRepo.updateReject(loansApp);
    }
    public List<LoansApp> implementlist(String status){
        return loansAppRepo.findAllBystatusofApproval(status);
    }
}
