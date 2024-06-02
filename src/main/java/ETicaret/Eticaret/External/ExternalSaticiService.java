package ETicaret.Eticaret.External;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;

import java.util.List;

public interface ExternalSaticiService {
    List<Satici> getAllSellers();
    void addSeller(SaticiEkleDto dto);
    void removeSeller(int id);
    void updateSeller(Integer id, String adSoyad, String marka, String eposta, String sifre);
}
