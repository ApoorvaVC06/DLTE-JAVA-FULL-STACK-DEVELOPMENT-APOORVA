package Repository;

import Entities.Studentss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentssRepository extends JpaRepository<Studentss, Integer> {

}
