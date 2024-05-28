package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;

import java.util.List;

public abstract class SaticiService {

    public abstract List<Satici> saticiListele();

    public abstract void saticiEkle(SaticiEkleDto dto);

    public abstract void saticiSil(int id);

    public abstract void saticiGuncelle(Integer id, String ad_soyad, String marka, String eposta, String sifre);
}
