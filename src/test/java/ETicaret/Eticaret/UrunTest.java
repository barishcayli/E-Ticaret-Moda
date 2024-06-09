import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Entity.Urun;
import ETicaret.Eticaret.Observer.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class UrunTest {

    private Urun urun;
    private Observer musteri;

    @BeforeEach
    void setUp() {
        urun = new Urun("Test Ürünü", 10, 100.0);
        musteri = mock(Musteri.class);
        urun.registerObserver(musteri);
    }

    @Test
    void testNotifyObserversWhenPriceChanges() {
        urun.setFiyat(120.0);
        String expectedMessage = "Ürünümüz olan Test Ürünü fiyatı 120.0 olarak değişmiştir";

        verify(musteri, times(1)).update(expectedMessage);

        // Çıktıyı ekrana yazdıralım
        System.out.println("Test başarılı: " + expectedMessage);
    }
}
