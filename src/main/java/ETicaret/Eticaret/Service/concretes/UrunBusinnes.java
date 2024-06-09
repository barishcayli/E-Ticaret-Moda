package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.UrunEkleDto;
import ETicaret.Eticaret.Repository.MusteriRepository;
import ETicaret.Eticaret.Repository.UrunRepository;
import ETicaret.Eticaret.Entity.Urun;
import ETicaret.Eticaret.Service.abstracts.UrunService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UrunBusinnes implements UrunService {


    private final UrunRepository urunRepository;

    public UrunBusinnes(UrunRepository urunRepository, MusteriRepository musteriRepository) {
        this.urunRepository = urunRepository;
    }

    @Override
    public List<Urun> urunListele() {
        List<Urun> urunler = urunRepository.findAll();
        return urunler;
    }


    @Override
    public void urunEkle(UrunEkleDto dto) {
        Urun urun = new Urun(dto.urunAdi(), dto.stokMiktari(), dto.fiyat());
        urunRepository.save(urun);
    }

    @Override
    public void urunSil(int urunId) {
        urunRepository.deleteById(urunId);
    }

    @Override
    public void urunGuncelle(int urunId, String yeniAd, int yeniStokMiktari, double yeniFiyat) {
        Optional<Urun> urunOptional = urunRepository.findById(urunId);
        if (urunOptional.isPresent()) {
            Urun urun = urunOptional.get();
            urun.setUrunAdi(yeniAd);
            urun.setStokMiktari(yeniStokMiktari);
            urun.setFiyat(yeniFiyat);
            urunRepository.save(urun);
        } else {
            System.out.println("Hata: Belirtilen ID'ye sahip ürün bulunamadı.");
        }
    }
    // Exception : İstisna yönetimi
    // Error

    @Override
    public void urunSat(int urunId, int satilanAdet) {
        Optional<Urun> urunOptional = urunRepository.findById(urunId);
        if (urunOptional.isPresent()) {
            Urun urun = urunOptional.get();
            int yeniStokMiktari= urun.getStokMiktari()-satilanAdet;
            if (yeniStokMiktari == 0) {
                urunRepository.deleteById(urunId);
            } else if (yeniStokMiktari < 0) {
                throw new RuntimeException("Hata: Stoğumuzda bu kadar ürün yok malesef");

            } else {
                urun.setStokMiktari(yeniStokMiktari);
                urunRepository.save(urun);
            }
        } else {
            System.out.println("Hata: Belirtilen ID'ye sahip ürün bulunamadı.");
        }
    }




}
