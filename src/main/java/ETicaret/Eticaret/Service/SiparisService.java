package ETicaret.Eticaret.Service;

import ETicaret.Eticaret.Entity.Siparis;
import ETicaret.Eticaret.Repository.SiparisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SiparisService {

    @Autowired
    private SiparisRepository siparisRepository;

    public void SiparisEkle(int musteri_id, int urun_id, int adet, String siparis_adresi, String siparis_tarihi, String teslim_tarihi) {


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {

            Date dateSiparis = dateFormat.parse(siparis_tarihi);
            Date dateTeslim = dateFormat.parse(teslim_tarihi);
            System.out.println(dateTeslim.getTime());
            Siparis siparis = new Siparis(musteri_id,urun_id,adet,siparis_adresi,dateSiparis,dateTeslim);

        siparisRepository.save(siparis);
        }
        catch (ParseException e) {
            System.out.println("Hata: Tarih formatı uygun değil");

        }

        }
        @Transactional
        public void SiparisSil(long SilSiparisId){

        siparisRepository.deleteById(SilSiparisId);
    }


    public void SiparisListele(){
        List<Siparis> siparisList = siparisRepository.findAll();
        for (Siparis siparis : siparisList) {
            System.out.println(siparis.toString());

        }
    }

    public void AdresGuncelle(long SiparisId, String YeniAdres){
         Optional<Siparis> siparisOptional = siparisRepository.findById(SiparisId);
         if (siparisOptional.isPresent()) {
             Siparis siparis = siparisOptional.get();
             siparis.setSiparis_adresi(YeniAdres);
             siparisRepository.save(siparis);

         }
    }


}
