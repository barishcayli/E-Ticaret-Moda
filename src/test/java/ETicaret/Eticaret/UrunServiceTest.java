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
        int satilanAdet = 15;

        Urun urun = new Urun("Test Urun", 10, 100.0);
        Optional<Urun> optionalUrun = Optional.of(urun);

        when(urunRepository.findById(urunId)).thenReturn(optionalUrun);

        urunBusinnes.urunSat(urunId, satilanAdet);

        assertEquals(10, urun.getStokMiktari()); // Stoğun değişmemesi gerekiyor
        verify(urunRepository, never()).save(any(Urun.class)); // save metodunun çağrılmaması gerekiyor
    }

    @Test
    public void testUrunStokGoster_UrunVar() {
        int urunId = 1;
        Urun urun = new Urun("Test Urun", 10, 100.0);
        Optional<Urun> optionalUrun = Optional.of(urun);

        when(urunRepository.findById(urunId)).thenReturn(optionalUrun);

        String result = urunBusinnes.urunStokGoster(urunId);

        assertTrue(result.contains("Ürün Adı: Test Urun, Stok Miktarı: 10"));
    }

    @Test
    public void testUrunStokGoster_UrunYok() {
        int urunId = 2;

        when(urunRepository.findById(urunId)).thenReturn(Optional.empty());

        String result = urunBusinnes.urunStokGoster(urunId);

        assertEquals("Hata: Belirtilen ID'ye sahip ürün bulunamadı.", result);
    }
}
