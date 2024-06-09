package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.SaticiDegerlendirmeEkleDto;
import ETicaret.Eticaret.Entity.SaticiDegerlendirme;

import ETicaret.Eticaret.Repository.SaticiDegerlendirmeRepository;
import ETicaret.Eticaret.Service.abstracts.SaticiDegerlendirmeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaticiDegerlendirmeBusinnes implements SaticiDegerlendirmeService {
    private final SaticiDegerlendirmeRepository saticiDegerlendirmeRepository;


    @Autowired
    public SaticiDegerlendirmeBusinnes(SaticiDegerlendirmeRepository saticiDegerlendirmeRepository) {
        this.saticiDegerlendirmeRepository = saticiDegerlendirmeRepository;

    }

    @Override
    public void saticiDegerlendirmeListele(int deger) {
        List<Integer> degerlendirmeler = saticiDegerlendirmeRepository.findBySaticiId(deger);
        if (!degerlendirmeler.isEmpty()) {
            for (Integer degerlendirme : degerlendirmeler) {
                System.out.println(degerlendirme);
            }
        } else {
            System.out.println("Hata: Belirtilen kritere uygun değerlendirme bulunamadı.");
        }
    }

    @Override
    public void saticiOrtalamasi(int saticiId) {
        List<Integer> degerlendirmeler = saticiDegerlendirmeRepository.findBySaticiId(saticiId);
        if (!degerlendirmeler.isEmpty()) {
            double toplam = 0;
            for (Integer degerlendirme : degerlendirmeler) {
                toplam += degerlendirme;
            }
            double ortalamasi = toplam / degerlendirmeler.size();
            String formatliOrtalama = String.format("%.2f", ortalamasi);
            System.out.println(formatliOrtalama);
        } else {
            System.out.println("Hata: Belirtilen kritere uygun değerlendirme bulunamadı.");
        }
    }

    @Override
    public void degerlendirmeEkle(SaticiDegerlendirmeEkleDto dto) {
        SaticiDegerlendirme yeniDegerlendirme = new SaticiDegerlendirme(dto.verilenPuan(), dto.saticiId(), dto.musteriId());
        saticiDegerlendirmeRepository.save(yeniDegerlendirme);
            }

    @Override
    @Transactional
    public void degerlendirmeSil(int degerlendirmeId) {
        saticiDegerlendirmeRepository.deleteById(degerlendirmeId);
    }
}
