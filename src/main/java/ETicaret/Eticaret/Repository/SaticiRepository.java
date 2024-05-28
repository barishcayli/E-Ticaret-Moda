package ETicaret.Eticaret.Repository;

import ETicaret.Eticaret.Entity.Satici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface SaticiRepository extends JpaRepository<Satici, Integer> {






}
