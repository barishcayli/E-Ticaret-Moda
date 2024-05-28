package ETicaret.Eticaret.Service.concretes;



import ETicaret.Eticaret.Dtos.SiparisEkleDto;
import ETicaret.Eticaret.Entity.Siparis;
import ETicaret.Eticaret.Repository.SiparisRepository;

import ETicaret.Eticaret.Service.abstracts.SiparisService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SiparisBusinnes implements  SiparisService {

    @Autowired
    private SiparisRepository siparisRepository;

    @Override
    public void siparisEkle(SiparisEkleDto dto) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date dateSiparis = dateFormat.parse(String.valueOf(dto.siparis_tarihi()));
            Date dateTeslim = dateFormat.parse(String.valueOf(dto.teslim_tarihi()));
            Siparis siparis = new Siparis(dto.musteriId(), dto.urunId(), dto.miktar(), dto.siparis_adresi(), dateSiparis, dateTeslim);
            siparisRepository.save(siparis);
        } catch (ParseException e) {
            System.out.println("Hata: Tarih formatı uygun değil");
        }
    }

    @Override
    @Transactional
    public void siparisSil(int SilSiparisId) {
        siparisRepository.deleteById(SilSiparisId);
    }

    @Override
    public List<Siparis> siparisListele() {
        List<Siparis> siparisList = siparisRepository.findAll();
        for (Siparis siparis : siparisList) {
            System.out.println(siparis.toString());
        }
        return siparisList;
    }

    @Override
    public void adresGuncelle(int SiparisId, String YeniAdres) {
        Optional<Siparis> siparisOptional = siparisRepository.findById(SiparisId);
        if (siparisOptional.isPresent()) {
            Siparis siparis = siparisOptional.get();
            siparis.setSiparis_adresi(YeniAdres);
            siparisRepository.save(siparis);
        }
    }
}


