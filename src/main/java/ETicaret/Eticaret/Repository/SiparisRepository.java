package ETicaret.Eticaret.Repository;

import ETicaret.Eticaret.Entity.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiparisRepository extends JpaRepository<Siparis, Integer> {


}
