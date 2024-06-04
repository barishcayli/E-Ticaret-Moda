package ETicaret.Eticaret;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Dtos.SaticiGuncelleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Service.concretes.SaticiBusinnes;
import ETicaret.Eticaret.Service.Facade.SaticiFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SaticiFacadeTest {


    @Mock
    private SaticiBusinnes saticiBusinnes;

    @InjectMocks
    private SaticiFacade saticiFacade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaticiListele() {
        Satici satici1 = new Satici();
        satici1.setId(1);
        satici1.setAd_soyad("Ali Veli");

        Satici satici2 = new Satici();
        satici2.setId(2);
        satici2.setAd_soyad("Ayşe Fatma");

        List<Satici> saticilar = Arrays.asList(satici1, satici2);

        when(saticiBusinnes.saticiListele()).thenReturn(saticilar);

        List<Satici> result = saticiFacade.saticiListele();
        assertEquals(2, result.size());
        assertEquals("Ali Veli", result.get(0).getAd_soyad());
        assertEquals("Ayşe Fatma", result.get(1).getAd_soyad());

        verify(saticiBusinnes, times(1)).saticiListele();
    }

    @Test
    public void testSaticiEkle() {
        SaticiEkleDto dto = new SaticiEkleDto();
        dto.setad_soyad("Ali Veli");
        dto.setmarka_adi("Marka1");
        dto.setEposta("ali@veli.com");
        dto.setSifre("123456");

        doNothing().when(saticiBusinnes).saticiEkle(dto);

        saticiFacade.saticiEkle(dto);

        verify(saticiBusinnes, times(1)).saticiEkle(dto);
    }

    @Test
    public void testSaticiSil() {
        int id = 1;

        doNothing().when(saticiBusinnes).saticiSil(id);

        saticiFacade.saticiSil(id);

        verify(saticiBusinnes, times(1)).saticiSil(id);
    }

    @Test
    public void testSaticiGuncelle() {
        SaticiGuncelleDto dto = new SaticiGuncelleDto();
        dto.setId(1);
        dto.setad_soyad("Ali Veli Güncellendi");
        dto.setmarka_adi("Marka1");
        dto.setEposta("ali@veli.com");
        dto.setSifre("yeniSifre");

        doNothing().when(saticiBusinnes).saticiGuncelle(dto);

        saticiFacade.saticiGuncelle(dto);

        verify(saticiBusinnes, times(1)).saticiGuncelle(dto);
    }
}


