package ETicaret.Eticaret.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import ETicaret.Eticaret.Repository.UrunRepository;
import ETicaret.Eticaret.Entity.Urun;

@Service
public class UrunService {

    @Autowired
    private UrunRepository urunRepository;

    public void UrunListele() {
        List<Urun> urunler = urunRepository.findAll();
        for (Urun urun : urunler) {
            System.out.println(urun);
        }
    }

    public void UrunEkle(String urunAdi, int stokMiktari, double fiyat) {
        Urun urun = new Urun(urunAdi, stokMiktari, fiyat);
        urunRepository.save(urun);
    }


    public void UrunSil(long urunId) {

        urunRepository.deleteById(urunId);
    }

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

    public void UrunSat(int urunId, int SatilanAdet) {
        Optional<Urun> urunOptional = urunRepository.findById(urunId);
        if (urunOptional.isPresent()) {
            Urun urun = urunOptional.get();

            int yeniStokMiktari= urun.getStokMiktari()-SatilanAdet;

            if (yeniStokMiktari == 0) {
                urunRepository.deleteById(urunId);
            }
            else if (yeniStokMiktari < 0) {
                System.out.println("Hata: Stoğumuzda bu kadar ürün yok malesef");
            }
            else{
                urun.setStokMiktari(yeniStokMiktari);
                urunRepository.save(urun);}
        }
        else {
            System.out.println("Hata: Belirtilen ID'ye sahip ürün bulunamadı.");
        }
    }

}
