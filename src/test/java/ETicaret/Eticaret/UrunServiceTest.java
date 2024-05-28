package ETicaret.Eticaret;

import ETicaret.Eticaret.Dtos.UrunEkleDto;
import ETicaret.Eticaret.Entity.Urun;
import ETicaret.Eticaret.Repository.UrunRepository;
import ETicaret.Eticaret.Service.concretes.UrunBusinnes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UrunServiceTest {

    @Mock
    private UrunRepository urunRepository;

    @InjectMocks
    private UrunBusinnes urunBusinnes;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUrunEkle() {
        UrunEkleDto dto = new UrunEkleDto("Test Urun", 10, 100.0);
        Urun urun = new Urun(dto.urunAdi(), dto.stokMiktari(), dto.fiyat());

        when(urunRepository.save(any(Urun.class))).thenReturn(urun);

        urunBusinnes.urunEkle(dto);

        verify(urunRepository, times(1)).save(any(Urun.class));
    }

    @Test
    public void testUrunSil() {
        int urunId = 1;

        doNothing().when(urunRepository).deleteById(urunId);

        urunBusinnes.urunSil(urunId);

        verify(urunRepository, times(1)).deleteById(urunId);
    }

    @Test
    public void testUrunGuncelle() {
        int urunId = 1;
        String yeniAd = "Yeni Test Urun";
        int yeniStokMiktari = 20;
        double yeniFiyat = 200.0;

        Urun urun = new Urun("Eski Test Urun", 10, 100.0);
        Optional<Urun> optionalUrun = Optional.of(urun);

        when(urunRepository.findById(urunId)).thenReturn(optionalUrun);
        when(urunRepository.save(any(Urun.class))).thenReturn(urun);

        urunBusinnes.urunGuncelle(urunId, yeniAd, yeniStokMiktari, yeniFiyat);

        assertEquals(yeniAd, urun.getUrunAdi());
        assertEquals(yeniStokMiktari, urun.getStokMiktari());
        assertEquals(yeniFiyat, urun.getFiyat());
        verify(urunRepository, times(1)).save(any(Urun.class));
    }

    @Test
    public void testUrunSat_StokYeterli() {
        int urunId = 1;
        int satilanAdet = 5;

        Urun urun = new Urun("Test Urun", 10, 100.0);
        Optional<Urun> optionalUrun = Optional.of(urun);

        when(urunRepository.findById(urunId)).thenReturn(optionalUrun);
        when(urunRepository.save(any(Urun.class))).thenReturn(urun);

        urunBusinnes.urunSat(urunId, satilanAdet);

        assertEquals(5, urun.getStokMiktari());
        verify(urunRepository, times(1)).save(any(Urun.class));
    }
    @Test
     public void testUrunSat_StokYetersiz() {
        int urunId = 1;
        int satilanAdet = 50;

        Urun urun = new Urun("Test Urun", 10, 100.0);
        Optional<Urun> optionalUrun = Optional.of(urun);

        when(urunRepository.findById(urunId)).thenReturn(optionalUrun);
        assertThrows(RuntimeException.class , ()->{
           urunBusinnes.urunSat(urunId,satilanAdet);
        });
    }
@Test
public void testUrunSat_StokYetersiz1(){
          int urunId = 1;
          int satilanAdet = 50;
}
  @Test
    public void testUrunListele() {
        // Given
        Urun urun1 = new Urun();
        urun1.setUrunAdi("Ürün 1");
        urun1.setStokMiktari(10);
        urun1.setFiyat(100.0);

        Urun urun2 = new Urun();
        urun2.setUrunAdi("Ürün 2");
        urun2.setStokMiktari(20);
        urun2.setFiyat(200.0);

        List<Urun> urunList = Arrays.asList(urun1, urun2);

        // When
        when(urunRepository.findAll()).thenReturn(urunList);

        // Then
        List<Urun> result = urunBusinnes.urunListele();
        assertEquals(2, result.size());
        assertEquals("Ürün 1", result.get(0).getUrunAdi());
        assertEquals(10, result.get(0).getStokMiktari());
        assertEquals(100.0, result.get(0).getFiyat());

        assertEquals("Ürün 2", result.get(1).getUrunAdi());
        assertEquals(20, result.get(1).getStokMiktari());
        assertEquals(200.0, result.get(1).getFiyat());

        // Verify
        verify(urunRepository, times(1)).findAll();
    }


}
