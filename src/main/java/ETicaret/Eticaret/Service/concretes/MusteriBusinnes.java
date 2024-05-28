package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.MusteriEkleDto;
import ETicaret.Eticaret.Dtos.MusteriGuncelleDto;
import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Repository.MusteriRepository;

import ETicaret.Eticaret.Service.abstracts.MusteriService;

import ETicaret.Eticaret.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusteriBusinnes implements MusteriService {

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
    public void musteriGuncelle(MusteriGuncelleDto dto) throws NotFoundException {
        Optional<Musteri> musteriOptional = musteriRepository.findById((int) dto.musteriId());
        if (musteriOptional.isPresent()) {
            Musteri musteri = musteriOptional.get();
            musteri.setAdSoyad(dto.adSoyad());
            musteri.setAdres(dto.adres());
            musteri.setEposta(dto.eposta());
            musteri.setSifre(dto.sifre());
            musteriRepository.save(musteri);
        } else {
           throw new NotFoundException("Hata: Müşteri bulunamadı.");
        }
    }





    // SOLID : O OPEN CLOSED
}
