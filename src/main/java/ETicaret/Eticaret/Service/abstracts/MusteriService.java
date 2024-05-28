package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.MusteriEkleDto;
import ETicaret.Eticaret.Entity.Musteri;

import java.util.List;

public interface  MusteriService {

     List<Musteri> musteriListele();

     void musteriEkle(MusteriEkleDto dto);

    void musteriSil(int MusteriId);

    void musteriGuncelle(long MusteriId, String YeniMusteriAdSoyad, String YeniMusteriAdres, String YeniMusteriEposta, String YeniMusteriSifre);
}
