package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.SiparisEkleDto;
import ETicaret.Eticaret.Entity.Siparis;

import java.util.List;

public abstract class SiparisService {

    public abstract void siparisEkle(SiparisEkleDto dto);

    public abstract void siparisSil(int SilSiparisId);

    public abstract List<Siparis> siparisListele();

    public abstract void adresGuncelle(int SiparisId, String YeniAdres);
}
