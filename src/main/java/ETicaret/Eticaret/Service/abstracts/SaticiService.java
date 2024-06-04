package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Dtos.SaticiGuncelleDto;
import ETicaret.Eticaret.Entity.Satici;

import java.util.List;

public interface SaticiService {

    List<Satici> saticiListele();

     void saticiEkle(SaticiEkleDto dto);

     void saticiSil(int id);

     void saticiGuncelle(SaticiGuncelleDto dto);


}
