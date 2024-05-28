package ETicaret.Eticaret.Controller;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Service.abstracts.SaticiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satici")
public class SaticiController {

    private final SaticiService saticiService;

    @Autowired
    public SaticiController(SaticiService saticiService) {
        this.saticiService = saticiService;
    }

    @GetMapping("/listele")
    public List<Satici> saticilariListele() {
        return saticiService.saticiListele();
    }

    @PostMapping("/ekle")
    public void saticiEkle(@RequestBody SaticiEkleDto dto) {
        saticiService.saticiEkle(dto);
    }

    @DeleteMapping("/sil/{id}")
    public void saticiSil(@PathVariable int id) {
        saticiService.saticiSil(id);
    }

    @PutMapping("/guncelle/{id}")
    public void saticiGuncelle(@PathVariable int id,
                               @RequestParam String adSoyad,
                               @RequestParam String marka,
                               @RequestParam String eposta,
                               @RequestParam String sifre) {
        saticiService.saticiGuncelle(id, adSoyad, marka, eposta, sifre);
    }
}
