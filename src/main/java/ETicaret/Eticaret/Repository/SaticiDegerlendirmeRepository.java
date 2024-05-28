package ETicaret.Eticaret.Repository;

import ETicaret.Eticaret.Entity.SaticiDegerlendirme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaticiDegerlendirmeRepository extends JpaRepository<SaticiDegerlendirme, Integer> {


    @Query("SELECT s.verilenPuan FROM SaticiDegerlendirme s WHERE s.saticiId = :deger")
    List<Integer> findBySaticiId(int deger);




    }
