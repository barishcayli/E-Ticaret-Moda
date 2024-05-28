package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.UrunEkleDto;
import ETicaret.Eticaret.Entity.Urun;

import java.util.List;

public interface UrunService {

     List<Urun> urunListele();

     void urunEkle(UrunEkleDto dto);

     void urunSil(int urunId);

     void urunGuncelle(int urunId, String yeniAd, int yeniStokMiktari, double yeniFiyat);

     void urunSat(int urunId, int satilanAdet);


}
