package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.MusteriEkleDto;
import ETicaret.Eticaret.Dtos.MusteriGuncelleDto;
import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.exceptions.NotFoundException;

import java.util.List;

public interface  MusteriService {

     List<Musteri> musteriListele();

     void musteriEkle(MusteriEkleDto dto);

    void musteriSil(int MusteriId);

    void musteriGuncelle(MusteriGuncelleDto dto) throws NotFoundException;
}
