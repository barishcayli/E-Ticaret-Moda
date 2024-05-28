package ETicaret.Eticaret;
import ETicaret.Eticaret.Dtos.UrunEkleDto;
import ETicaret.Eticaret.Entity.Urun;
import ETicaret.Eticaret.Repository.UrunRepository;
import ETicaret.Eticaret.Service.UrunService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UrunServiceTest {

    @Mock
    private UrunRepository urunRepository;

    @InjectMocks
    private UrunService urunService;

    private Urun urun;

    @BeforeEach
    void setUp() {
        urun = new Urun();
        urun.setId(1);
        urun.setUrunAdi("Test Urun");
        urun.setStokMiktari(10);
        urun.setFiyat(100.0);
    }

    @Test
    void testUrunListele() {
        when(urunRepository.findAll()).thenReturn(Arrays.asList(urun));

        var urunler = urunService.urunListele();

        assertEquals(1, urunler.size());
        verify(urunRepository, times(1)).findAll();
    }

    @Test
    void testUrunEkle() {
        UrunEkleDto dto = new UrunEkleDto("Yeni Urun", 20, 200.0);
        Urun yeniUrun = new Urun(dto.urunAdi(), dto.stokMiktari(), dto.fiyat());

        urunService.urunEkle(dto);

        verify(urunRepository, times(1)).save(any(Urun.class));
    }

    @Test
    void testUrunSil() {
        doNothing().when(urunRepository).deleteById(1);

        urunService.urunSil(1);

        verify(urunRepository, times(1)).deleteById(1);
    }

    @Test
    void testUrunGuncelle() {
        when(urunRepository.findById(1)).thenReturn(Optional.of(urun));

        urunService.urunGuncelle(1, "Guncel Urun", 5, 150.0);

        verify(urunRepository, times(1)).save(urun);
        assertEquals("Guncel Urun", urun.getUrunAdi());
        assertEquals(5, urun.getStokMiktari());
        assertEquals(150.0, urun.getFiyat());
    }

    @Test
    void testUrunSat() {
        when(urunRepository.findById(1)).thenReturn(Optional.of(urun));

        urunService.urunSat(1, 5);

        verify(urunRepository, times(1)).save(urun);
        assertEquals(5, urun.getStokMiktari());
    }

    @Test
    void testUrunStokGoster() {
        when(urunRepository.findById(1)).thenReturn(Optional.of(urun));

        urunService.urunStokGoster(1);

        verify(urunRepository, times(1)).findById(1);
    }

}