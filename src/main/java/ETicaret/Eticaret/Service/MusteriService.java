package ETicaret.Eticaret.Service;

import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Entity.Urun;
import ETicaret.Eticaret.Repository.MusteriRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.SimpleTimeZone;

@Service
public class MusteriService {

    @Autowired
    private MusteriRepository musteriRepository;

    public void MusteriListele() {
        List<Musteri> musteriler = musteriRepository.findAll();
        for (Musteri musteri : musteriler) {
            System.out.println(musteri);
        }
    }

    public void MusteriEkle(String MusteriAdSoyad,String MusteriAdres,String MusteriEposta, String MusteriSifre) {
        Musteri EklenecekMusteri=new Musteri(MusteriAdSoyad,MusteriAdres,MusteriEposta,MusteriSifre);
        musteriRepository.save(EklenecekMusteri);
    }

    @Transactional
    public void MusteriSil(long MusteriId) {
        musteriRepository.deleteById(MusteriId);
    }

    public void MusteriGuncelle(long MusteriId,
                                String YeniMusteriAdSoyad,
                                String YeniMusteriAdres,
                                String YeniMusteriEposta,
                                String YeniMusteriSifre) {

Optional<Musteri> musteriOptional = musteriRepository.findById((int) MusteriId);


    if (musteriOptional.isPresent()) {
        Musteri musteri = musteriOptional.get();

        musteri.setAdSoyad(YeniMusteriAdSoyad);
        musteri.setAdres(YeniMusteriAdres);
        musteri.setEposta(YeniMusteriEposta);
        musteri.setSifre(YeniMusteriSifre);
        musteriRepository.save(musteri);

    }
    else {
        System.out.println("Hata: Müşteri bulunamadı.");
}

    }

}
