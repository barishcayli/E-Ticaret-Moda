package ETicaret.Eticaret.Controller;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Dtos.SaticiGuncelleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Service.Facade.SaticiFacade;
import ETicaret.Eticaret.Service.abstracts.SaticiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/satici")
public class SaticiController {

    private final SaticiFacade saticiService;

    @Autowired
    public SaticiController(@Qualifier("saticiFacade") SaticiService saticiService) {
        this.saticiService = (SaticiFacade) saticiService;
    }

    @GetMapping("/listele")
    public List<Satici> listele() {
        return saticiService.saticiListele();
    }

    @PostMapping("/ekle")
    public void ekle(@RequestBody SaticiEkleDto dto) {
        saticiService.saticiEkle(dto);
    }

    @DeleteMapping("/sil/{id}")
        public void sil(@Valid @PathVariable int id) {
        saticiService.saticiSil(id);
    }

    @PutMapping("/guncelle")
    public void guncelle(@Valid @RequestBody SaticiGuncelleDto dto) {
        saticiService.saticiGuncelle(dto);
    }
}
