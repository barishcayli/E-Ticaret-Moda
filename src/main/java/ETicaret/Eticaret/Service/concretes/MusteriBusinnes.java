package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.MusteriEkleDto;
import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Repository.MusteriRepository;

import ETicaret.Eticaret.Service.abstracts.MusteriService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusteriBusinnes extends MusteriService {

    private final MusteriRepository musteriRepository;


    public MusteriBusinnes(MusteriRepository musteriRepository) {
        this.musteriRepository = musteriRepository;
    }

    @Override
    public List<Musteri> musteriListele() {
        return musteriRepository.findAll();
    }

    @Override
    public void musteriEkle(MusteriEkleDto dto) {
        musteriRepository.save(new Musteri(dto.adSoyad(), dto.adres(), dto.eposta(), dto.sifre()));
    }

    @Override
    @Transactional
    public void musteriSil(int MusteriId) {
        musteriRepository.deleteById(MusteriId);
    }

    @Override
    public void musteriGuncelle(long MusteriId, String YeniMusteriAdSoyad, String YeniMusteriAdres, String YeniMusteriEposta, String YeniMusteriSifre) {
        Optional<Musteri> musteriOptional = musteriRepository.findById((int) MusteriId);
        if (musteriOptional.isPresent()) {
            Musteri musteri = musteriOptional.get();
            musteri.setAdSoyad(YeniMusteriAdSoyad);
            musteri.setAdres(YeniMusteriAdres);
            musteri.setEposta(YeniMusteriEposta);
            musteri.setSifre(YeniMusteriSifre);
            musteriRepository.save(musteri);
        } else {
            System.out.println("Hata: Müşteri bulunamadı.");
        }
    }
}
