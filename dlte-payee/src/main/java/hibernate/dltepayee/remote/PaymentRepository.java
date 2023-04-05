package hibernate.dltepayee.remote;

import hibernate.dltepayee.model.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    @Query("Select upi from Payment ")
    List<Integer> findAllUpi();

   @Query("select payeeName from Payment where ifscCode=:ifscCode")
    List<String> findAllByIfscCode(String ifscCode);

   List<Payment> findAllByifscCode(String ifsc);

   @Modifying
   @Transactional
   @Query("update Payment set upi=upi-10 where upi<=5000")
    void updateUpi();

   @Query(value="select * from Payment where upi=?1", nativeQuery = true)
    List<Payment> getRecordsOnUpi(Integer upi);
}
