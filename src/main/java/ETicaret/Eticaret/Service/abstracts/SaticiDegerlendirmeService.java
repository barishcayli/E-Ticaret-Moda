package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.SaticiDegerlendirmeEkleDto;
import ETicaret.Eticaret.Entity.SaticiDegerlendirme;

import java.util.List;
//

public interface SaticiDegerlendirmeService {

     void saticiDegerlendirmeListele(int deger);

     void saticiOrtalamasi(int saticiId);

     void degerlendirmeEkle(SaticiDegerlendirmeEkleDto dto);

     void degerlendirmeSil(int degerlendirmeId);
}
