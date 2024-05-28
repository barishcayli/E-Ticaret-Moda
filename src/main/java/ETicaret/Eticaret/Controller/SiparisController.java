package ETicaret.Eticaret.Controller;

import ETicaret.Eticaret.Dtos.SiparisEkleDto;
import ETicaret.Eticaret.Entity.Siparis;
import ETicaret.Eticaret.Service.SiparisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siparis")
public class SiparisController {

    private final SiparisService siparisService;

    @Autowired
    public SiparisController(SiparisService siparisService) {
        this.siparisService = siparisService;
    }

    @PostMapping("/ekle")
    public void siparisEkle(SiparisEkleDto dto) {
        siparisService.siparisEkle(dto);
    }

    @DeleteMapping("/sil/{id}")
    public void siparisSil(@PathVariable int id) {
        siparisService.siparisSil(id);
    }

    @GetMapping("/listele")
    public List<Siparis> siparisListele() {
        return siparisService.siparisListele();
    }

    @PutMapping("/guncelle-adres/{id}")
    public void adresGuncelle(@PathVariable int id,
                              @RequestParam String yeniAdres) {
        siparisService.adresGuncelle(id, yeniAdres);
    }
}
