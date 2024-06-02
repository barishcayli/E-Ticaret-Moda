package ETicaret.Eticaret.Controller;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Service.abstracts.SaticiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/satici")
public class SaticiController {

    private final SaticiService saticiService;

    @Autowired
    public SaticiController(SaticiService saticiService) {
        this.saticiService = saticiService;
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
    public void sil(@PathVariable int id) {
        saticiService.saticiSil(id);
    }

    @PutMapping("/guncelle/{id}")
    public void guncelle(@PathVariable Integer id, @RequestBody SaticiEkleDto dto) {
        saticiService.saticiGuncelle(id, dto.getAdSoyad(), dto.getMarkaAdi(), dto.getEposta(), dto.getSifre());
    }
}
