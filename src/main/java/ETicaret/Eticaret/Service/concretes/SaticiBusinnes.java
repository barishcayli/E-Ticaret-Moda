package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
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
        saticiRepository.save(new Satici(dto.ad_soyad(), dto.marka_adi(), dto.eposta(), dto.sifre()));
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
