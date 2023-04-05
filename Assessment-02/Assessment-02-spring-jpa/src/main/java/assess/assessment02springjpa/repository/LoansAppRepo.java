package assess.assessment02springjpa.repository;

import assess.assessment02springjpa.Entity.LoansApp;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface LoansAppRepo extends CrudRepository<LoansApp , Integer> {
    @Modifying
    @Transactional           //update status of approval
    @Query(value ="update LoansApp set statusofApproval='Approved' where cibil>700 and income>=:reqAmt*3 and profession in('selfemployee','salaried')" ,nativeQuery = true)
    LoansApp updatestatus(LoansApp loansApp);

    @Modifying
    @Transactional           //update status of approval
    @Query(value ="update LoansApp set statusofApproval='Rejected' where cibil<700 and income<=:reqAmt*3 or profession not in('selfemployee','salaried')" ,nativeQuery = true)
    LoansApp updateReject(LoansApp loansApp);

    @Query("from LoansApp where statusofApproval=:status")
    List<LoansApp> findAllBystatusofApproval(String status);
}
