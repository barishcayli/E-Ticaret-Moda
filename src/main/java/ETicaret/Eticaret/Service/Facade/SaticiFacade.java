package ETicaret.Eticaret.Service.Facade;


import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Dtos.SaticiGuncelleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Service.abstracts.SaticiService;
import ETicaret.Eticaret.Service.concretes.SaticiBusinnes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaticiFacade implements SaticiService {

    private final SaticiBusinnes saticiBusinnes;

    public SaticiFacade(SaticiBusinnes saticiBusinnes) {
        this.saticiBusinnes = saticiBusinnes;
    }

    @Override
    public List<Satici> saticiListele() {
        return saticiBusinnes.saticiListele();
    }

    @Override
    public void saticiEkle(SaticiEkleDto dto) {
        saticiBusinnes.saticiEkle(dto);
    }

    @Override
    public void saticiSil(int id) {
        saticiBusinnes.saticiSil(id);
    }

    @Override
    public void saticiGuncelle(SaticiGuncelleDto dto) {
        saticiBusinnes.saticiGuncelle(dto);

    }


}




