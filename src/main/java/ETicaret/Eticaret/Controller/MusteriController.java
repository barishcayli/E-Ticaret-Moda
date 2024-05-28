package ETicaret.Eticaret.Controller;

import ETicaret.Eticaret.Dtos.MusteriEkleDto;
import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Service.MusteriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musteri")
public class MusteriController {

    private final MusteriService musteriService;

    @Autowired
    public MusteriController(MusteriService musteriService) {
        this.musteriService = musteriService;
    }

    @GetMapping("/listele")
    public List<Musteri> musterileriListele() {
        return musteriService.musteriListele();
    }

    @PostMapping("/ekle")
    public void musteriEkle(@RequestBody MusteriEkleDto dto) {
        musteriService.musteriEkle(dto);
    }

    @DeleteMapping("/sil/{id}")
    public void musteriSil(@PathVariable("id") int musteriId) {
        musteriService.musteriSil(musteriId);
    }

    @PutMapping("/guncelle/{id}")
    public void musteriGuncelle(@PathVariable("id") long musteriId,
                                @RequestParam String adSoyad,
                                @RequestParam String adres,
                                @RequestParam String eposta,
                                @RequestParam String sifre) {
        musteriService.musteriGuncelle(musteriId, adSoyad, adres, eposta, sifre);
    }
}
