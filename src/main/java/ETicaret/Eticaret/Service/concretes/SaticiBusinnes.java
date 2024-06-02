
package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.External.ExternalSaticiServiceImpl;
import ETicaret.Eticaret.Repository.SaticiRepository;
import ETicaret.Eticaret.Service.abstracts.SaticiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaticiBusinnes implements SaticiService {

    private final SaticiRepository saticiRepository;
    private final ExternalSaticiServiceImpl externalSaticiServiceImpl;


    public SaticiBusinnes(SaticiRepository saticiRepository, ExternalSaticiServiceImpl externalSaticiServiceImpl) {
        this.saticiRepository = saticiRepository;
        this.externalSaticiServiceImpl = externalSaticiServiceImpl;
    }

    @Override
    public List<Satici> saticiListele() {
        return saticiRepository.findAll();
    }

      @Override
    public void saticiEkle(SaticiEkleDto dto) {
        externalSaticiServiceImpl.addSeller(dto);
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
    public void saticiGuncelle(Integer id, String ad_soyad, String marka, String eposta, String sifre) {
        Satici satici = saticiRepository.findById(id).orElse(null);
        if (satici != null) {
            satici.setAd_soyad(ad_soyad);
            satici.setMarka_adi(marka);
            satici.setEposta(eposta);
            satici.setSifre(sifre);
            saticiRepository.save(satici);
        } else {
            System.out.println("Hata: Belirtilen ID'ye sahip satıcı bulunamadı.");
        }
    }
}
