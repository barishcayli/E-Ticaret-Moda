package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.MusteriEkleDto;
import ETicaret.Eticaret.Entity.Musteri;

import java.util.List;

public abstract class MusteriService {

    public abstract List<Musteri> musteriListele();

    public abstract void musteriEkle(MusteriEkleDto dto);

    public abstract void musteriSil(int MusteriId);

    public abstract void musteriGuncelle(long MusteriId, String YeniMusteriAdSoyad, String YeniMusteriAdres, String YeniMusteriEposta, String YeniMusteriSifre);
}
