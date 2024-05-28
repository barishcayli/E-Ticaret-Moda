package ETicaret.Eticaret.Service;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Repository.SaticiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaticiService {
    @Autowired
    private SaticiRepository saticiRepository;

     public List<Satici> saticiListele() {
        return saticiRepository.findAll();
    }
    public void saticiEkle(SaticiEkleDto dto){
        saticiRepository.save(new Satici(dto.ad_soyad(),dto.marka_adi(), dto.eposta(), dto.sifre()));

    }

    public void saticiSil(int id){
        Satici satici = saticiRepository.findById(id).get();
        saticiRepository.delete(satici);
    }
    public void saticiGuncelle(Integer id,String ad_soyad, String marka, String eposta, String sifre){
        Satici satici= saticiRepository.findById(id).get();
        satici.setAd_soyad(ad_soyad);
        satici.setMarka_adi(marka);
        satici.setEposta(eposta);
        satici.setSifre(sifre);
        saticiRepository.save(satici);
    }
}
