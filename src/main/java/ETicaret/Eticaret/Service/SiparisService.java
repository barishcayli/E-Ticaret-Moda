package ETicaret.Eticaret.Service;

import ETicaret.Eticaret.Entity.Siparis;
import ETicaret.Eticaret.Repository.SiparisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SiparisService {

    @Autowired
    private SiparisRepository siparisRepository;

    void SiparisEkle(int musteri_id, int urun_id, int adet, String siparis_adresi, Date siparis_tarihi, Date teslim_tarihi) {

        Siparis siparis = new Siparis(musteri_id,urun_id,adet,siparis_adresi,siparis_tarihi,teslim_tarihi);

        siparisRepository.save(siparis);
        }

    void SiparisSil(long SiparisId){

        siparisRepository.findById(SiparisId);
    }

    void SiparisListele(){
        List<Siparis> siparisList = siparisRepository.findAll();
        for (Siparis siparis : siparisList) {
            System.out.println(siparis.toString());

        }
    }

    void AdresGuncelle(long SiparisId, String YeniAdres){
         Optional<Siparis> siparisOptional = siparisRepository.findById(SiparisId);
         if (siparisOptional.isPresent()) {
             Siparis siparis = siparisOptional.get();
             siparis.setSiparis_adresi(YeniAdres);
             siparisRepository.save(siparis);

         }
    }


}
