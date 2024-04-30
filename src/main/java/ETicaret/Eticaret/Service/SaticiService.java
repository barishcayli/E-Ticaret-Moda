package ETicaret.Eticaret.Service;

import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Repository.SaticiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaticiService {
    @Autowired
    private SaticiRepository saticiRepository;

    public void SaticiListele(){
        List<Satici> saticiList = saticiRepository.findAll();
        for (Satici satici : saticiList) {
            System.out.println(satici.toString());//saticilari listeledik
        }
    }
    public void SaticiEkle(String ad_soyad, String marka, String eposta, String sifre){
        Satici satici = new Satici();
        satici.setAd_soyad(ad_soyad);
        satici.setMarka_adi(marka);
        satici.setEposta(eposta);
        satici.setSifre(sifre);
        saticiRepository.save(satici);

    }

    public void SaticiSil(int id){
        Satici satici = saticiRepository.findById(id).get();
        saticiRepository.delete(satici);
    }
    public void SaticiGüncelle(Integer id,String ad_soyad, String marka, String eposta, String sifre){
        Satici satici= saticiRepository.findById(id).get();
        satici.setAd_soyad(ad_soyad);
        satici.setMarka_adi(marka);
        satici.setEposta(eposta);
        satici.setSifre(sifre);
        saticiRepository.save(satici);
    }
}
