package ETicaret.Eticaret.Service;

import ETicaret.Eticaret.Dtos.MusteriEkleDto;
import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Repository.MusteriRepository;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MusteriService {


    private final MusteriRepository musteriRepository;

    public MusteriService(MusteriRepository musteriRepository) {
        this.musteriRepository = musteriRepository;
    }



    public List<Musteri> musteriListele() {
        List<Musteri> musteriler = musteriRepository.findAll();
        return  musteriler;
    }

    public void musteriEkle(MusteriEkleDto dto) {
        musteriRepository.save(new Musteri(dto.adSoyad(), dto.adres(), dto.eposta(), dto.sifre()));
    }

    @Transactional
    public void musteriSil(int MusteriId) {
        musteriRepository.deleteById(MusteriId);
    }

    public void musteriGuncelle(long MusteriId,
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
