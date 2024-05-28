package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.UrunEkleDto;
import ETicaret.Eticaret.Repository.UrunRepository;
import ETicaret.Eticaret.Entity.Urun;
import ETicaret.Eticaret.Service.abstracts.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrunBusinnes extends UrunService {

    @Autowired
    private UrunRepository urunRepository;

    @Override
    public List<Urun> urunListele() {
        List<Urun> urunler = urunRepository.findAll();
        for (Urun urun : urunler) {
            System.out.println(urun);
        }
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

    @Override
    public void urunSat(int urunId, int satilanAdet) {
        Optional<Urun> urunOptional = urunRepository.findById(urunId);
        if (urunOptional.isPresent()) {
            Urun urun = urunOptional.get();
            int yeniStokMiktari= urun.getStokMiktari()-satilanAdet;
            if (yeniStokMiktari == 0) {
                urunRepository.deleteById(urunId);
            } else if (yeniStokMiktari < 0) {
                System.out.println("Hata: Stoğumuzda bu kadar ürün yok malesef");
            } else {
                urun.setStokMiktari(yeniStokMiktari);
                urunRepository.save(urun);
            }
        } else {
            System.out.println("Hata: Belirtilen ID'ye sahip ürün bulunamadı.");
        }
    }

    @Override
    public String urunStokGoster(int urunId) {
        Optional<Urun> urunOptional = urunRepository.findById(urunId);
        if (urunOptional.isPresent()) {
            Urun urun = urunOptional.get();
            return("Ürün Adı: " + urun.getUrunAdi() + ", Stok Miktarı: " + urun.getStokMiktari());
        } else {
            return ("Hata: Belirtilen ID'ye sahip ürün bulunamadı.");
        }

    }
}
