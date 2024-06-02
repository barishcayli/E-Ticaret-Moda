package ETicaret.Eticaret.Adapter;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.External.ExternalSaticiService;
import ETicaret.Eticaret.Service.abstracts.SaticiService;

import java.util.List;

public class SaticiServiceAdapter implements SaticiService {

    private final ExternalSaticiService externalSellerService;

    public SaticiServiceAdapter(ExternalSaticiService externalSellerService, ExternalSaticiService externalSellerService1) {
        this.externalSellerService = externalSellerService1;

    }

    @Override
    public List<Satici> saticiListele() {
        return externalSellerService.getAllSellers();
    }

    @Override
    public void saticiEkle(SaticiEkleDto dto) {
        externalSellerService.addSeller(dto);
    }

    @Override
    public void saticiSil(int id) {
        externalSellerService.removeSeller(id);
    }

    @Override
    public void saticiGuncelle(Integer id, String adSoyad, String marka, String eposta, String sifre) {
        externalSellerService.updateSeller(id, adSoyad, marka, eposta, sifre);
    }
}
