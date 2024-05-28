package ETicaret.Eticaret.Controller;

import ETicaret.Eticaret.Dtos.SaticiDegerlendirmeEkleDto;
import ETicaret.Eticaret.Entity.SaticiDegerlendirme;
import ETicaret.Eticaret.Service.SaticiDegerlendirmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satici-degerlendirme")
public class SaticiDegerlendirmeController {

    private final SaticiDegerlendirmeService saticiDegerlendirmeService;

    @Autowired
    public SaticiDegerlendirmeController(SaticiDegerlendirmeService saticiDegerlendirmeService) {
        this.saticiDegerlendirmeService = saticiDegerlendirmeService;
    }

    @GetMapping("/listele/{saticiId}")
    public void saticiDegerlendirmeListele(@PathVariable int saticiId) {
        saticiDegerlendirmeService.saticiDegerlendirmeListele(saticiId);
    }

    @GetMapping("/ortalama/{saticiId}")
    public void saticiOrtalama(@PathVariable int saticiId) {
        saticiDegerlendirmeService.saticiOrtalamasi(saticiId);
    }

    @PostMapping("/ekle")
    public void degerlendirmeEkle(@RequestBody SaticiDegerlendirmeEkleDto dto) {

        saticiDegerlendirmeService.degerlendirmeEkle(dto);
    }

    @DeleteMapping("/sil/{degerlendirmeId}")
    public void degerlendirmeSil(@PathVariable int degerlendirmeId) {
        saticiDegerlendirmeService.degerlendirmeSil(degerlendirmeId);
    }
}
