package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.UrunEkleDto;
import ETicaret.Eticaret.Entity.Urun;

import java.util.List;

public abstract class UrunService {

    public abstract List<Urun> urunListele();

    public abstract void urunEkle(UrunEkleDto dto);

    public abstract void urunSil(int urunId);

    public abstract void urunGuncelle(int urunId, String yeniAd, int yeniStokMiktari, double yeniFiyat);

    public abstract void urunSat(int urunId, int satilanAdet);

    public abstract String urunStokGoster(int urunId);
}
