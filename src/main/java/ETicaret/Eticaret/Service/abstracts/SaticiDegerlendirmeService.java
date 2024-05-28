package ETicaret.Eticaret.Service.abstracts;

import ETicaret.Eticaret.Dtos.SaticiDegerlendirmeEkleDto;
import ETicaret.Eticaret.Entity.SaticiDegerlendirme;

import java.util.List;

public abstract class SaticiDegerlendirmeService {

    public abstract void saticiDegerlendirmeListele(int deger);

    public abstract void saticiOrtalamasi(int saticiId);

    public abstract void degerlendirmeEkle(SaticiDegerlendirmeEkleDto dto);

    public abstract void degerlendirmeSil(int degerlendirmeId);
}
