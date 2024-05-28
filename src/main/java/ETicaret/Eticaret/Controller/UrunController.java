package ETicaret.Eticaret.Controller;

import ETicaret.Eticaret.Dtos.UrunEkleDto;
import ETicaret.Eticaret.Entity.Urun;

import ETicaret.Eticaret.Service.abstracts.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urun")
public class UrunController {

    private final UrunService urunService;

    @Autowired
    public UrunController(UrunService urunService) {
        this.urunService = urunService;
    }

    @GetMapping("/listele")
    public List<Urun> urunListele() {
        return urunService.urunListele();
    }

    @PostMapping("/ekle")
    public void urunEkle(@RequestBody UrunEkleDto dto) {

        urunService.urunEkle(dto);
    }

    @DeleteMapping("/sil/{urunId}")
    public void urunSil(@PathVariable int urunId) {
        urunService.urunSil(urunId);
    }

    @PutMapping("/guncelle/{urunId}")
    public void urunGuncelle(@PathVariable int urunId,
                             @RequestParam String yeniAd,
                             @RequestParam int yeniStokMiktari,
                             @RequestParam double yeniFiyat) {
        urunService.urunGuncelle(urunId, yeniAd, yeniStokMiktari, yeniFiyat);
    }

    @PutMapping("/sat/{urunId}")
    public void urunSat(@PathVariable int urunId,
                        @RequestParam int satilanAdet) {
        urunService.urunSat(urunId, satilanAdet);
    }
}
