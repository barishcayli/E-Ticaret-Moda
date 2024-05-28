package ETicaret.Eticaret.Repository;


import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri,Integer> {
     List<Musteri> findByAdSoyad(String adSoyad);


}
