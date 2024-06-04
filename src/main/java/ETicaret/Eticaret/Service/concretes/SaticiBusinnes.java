
package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Dtos.SaticiGuncelleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Repository.SaticiRepository;
import ETicaret.Eticaret.Service.abstracts.SaticiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaticiBusinnes implements SaticiService {


    private final SaticiRepository saticiRepository;

    public SaticiBusinnes(SaticiRepository saticiRepository) {
        this.saticiRepository = saticiRepository;
    }

    @Override
    public List<Satici> saticiListele() {
        return saticiRepository.findAll();
    }

      @Override
    public void saticiEkle(SaticiEkleDto dto) {
        Satici satici = new Satici();
        satici.setAd_soyad(dto.getAdSoyad());
        satici.setMarka_adi(dto.getMarkaAdi());
        satici.setEposta(dto.getEposta());
        satici.setSifre(dto.getSifre());

        saticiRepository.save(satici);

      }

    @Override
    public void saticiSil(int id) {
        Satici satici = saticiRepository.findById(id).orElse(null);
        if (satici != null) {
            saticiRepository.delete(satici);
        } else {
            System.out.println("Hata: Belirtilen ID'ye sahip satıcı bulunamadı.");
        }
    }

    @Override
    public void saticiGuncelle(SaticiGuncelleDto dto) {
        Satici satici = saticiRepository.findById(dto.getId()).orElse(null);
        if (satici != null) {
            satici.setAd_soyad(dto.getAdSoyad());
            satici.setMarka_adi(satici.getMarka_adi());
            satici.setEposta(satici.getEposta());
            satici.setSifre(satici.getSifre());
            saticiRepository.save(satici);
        } else {
            System.out.println("Hata: Belirtilen ID'ye sahip satıcı bulunamadı.");
        }
    }
}
