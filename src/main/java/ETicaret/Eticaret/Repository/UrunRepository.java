package ETicaret.Eticaret.Repository;
import ETicaret.Eticaret.Entity.Urun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UrunRepository extends JpaRepository<Urun, Integer> {
    List<Urun> findByFiyatBetween(double minFiyat, double maxFiyat);

    void deleteById(Long id);

     Urun save(Urun urun);
}
