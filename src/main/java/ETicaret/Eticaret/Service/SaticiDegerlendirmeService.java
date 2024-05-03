package ETicaret.Eticaret.Service;

import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Entity.SaticiDegerlendirme;
import ETicaret.Eticaret.Repository.SaticiDegerlendirmeRepository;
import ETicaret.Eticaret.Repository.SaticiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaticiDegerlendirmeService {

    private static SaticiDegerlendirmeRepository saticiDegerlendirmeRepository;

    @Autowired
    public SaticiDegerlendirmeService(SaticiDegerlendirmeRepository saticiDegerlendirmeRepository) {
        SaticiDegerlendirmeService.saticiDegerlendirmeRepository = saticiDegerlendirmeRepository;
    }
   public static void saticiDegerlendirmeListele(int deger) {
        List<Integer> degerlendirmeler = saticiDegerlendirmeRepository.findBySaticiId(deger);
        if (!degerlendirmeler.isEmpty()) {
            for (Integer degerlendirme : degerlendirmeler) {
                System.out.println(degerlendirme);
            }
        } else {
            System.out.println("Hata: Belirtilen kritere uygun değerlendirme bulunamadı.");
        }
    }


    public static void SaticiOrtalaması(int saticiId) {
       List<Integer> degerlendirmeler = saticiDegerlendirmeRepository.findBySaticiId(saticiId);
      if(!degerlendirmeler.isEmpty()) {
          double toplam=0;
          for(Integer degerlendirme : degerlendirmeler){
              toplam+=degerlendirme;

          }
          double ortalamasi=toplam/degerlendirmeler.size();
            String formatliOrtalama = String.format("%.2f", ortalamasi);
            System.out.println(formatliOrtalama);


      }
      else {
          System.out.println("Hata: Belirtilen kritere uygun değerlendirme bulunamadı.");
      }
    }

    public void DegerlendirmeEkle(int degerlendirme, int saticiId, int musteriId) {
            SaticiDegerlendirme Degerlendirme = new SaticiDegerlendirme(degerlendirme,saticiId,musteriId);
            saticiDegerlendirmeRepository.save(Degerlendirme);
            System.out.println("Değerlendirme Eklendi");

    }

}


