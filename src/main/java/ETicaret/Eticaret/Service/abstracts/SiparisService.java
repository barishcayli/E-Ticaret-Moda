package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.SiparisEkleDto;
import ETicaret.Eticaret.Entity.Siparis;

import java.util.List;

public interface SiparisService {

     void siparisEkle(SiparisEkleDto dto);

     void siparisSil(int SilSiparisId);

     List<Siparis> siparisListele();

     void adresGuncelle(int SiparisId, String YeniAdres);
}
