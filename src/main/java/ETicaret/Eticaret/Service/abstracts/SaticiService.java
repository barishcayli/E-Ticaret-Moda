package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;

import java.util.List;

public interface SaticiService {

    List<Satici> saticiListele();

     void saticiEkle(SaticiEkleDto dto);

     void saticiSil(int id);

     void saticiGuncelle(Integer id, String ad_soyad, String marka, String eposta, String sifre);
}
