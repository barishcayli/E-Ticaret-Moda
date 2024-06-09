package ETicaret.Eticaret;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import ETicaret.Eticaret.Dtos.UrunEkleDto;
import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Repository.MusteriRepository;
import ETicaret.Eticaret.Repository.UrunRepository;
import ETicaret.Eticaret.Service.concretes.UrunBusinnes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) // MockitoExtension kullanılacak
public class UrunBusinessTests {

    @Mock
    private UrunRepository urunRepository;

    @Mock
    private MusteriRepository musteriRepository;

    @InjectMocks
    private UrunBusinnes urunBusinnes;

    @Test
    public void testUrunEkle_NotifiesAllCustomers() {
        // Arrange
        Musteri musteri1 = mock(Musteri.class); // mock nesnesi olarak oluşturuldu
        Musteri musteri2 = mock(Musteri.class); // mock nesnesi olarak oluşturuldu
        List<Musteri> musteriler = new ArrayList<>();
        musteriler.add(musteri1);
        musteriler.add(musteri2);

        // Müşteri repository'si findAll metodu çağrıldığında müşteri listesini döndürsün
        when(musteriRepository.findAll()).thenReturn(musteriler);

        UrunEkleDto urunDto = new UrunEkleDto("Laptop", 10, 2500.0);

        // Act
        urunBusinnes.urunEkle(urunDto);

        // Assert
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
        verify(musteri1).update(messageCaptor.capture());
        verify(musteri2).update(messageCaptor.capture());

        List<String> messages = messageCaptor.getAllValues();
        for (String message : messages) {
            System.out.println("Notification message: " + message);
            // Burada assertion yapabilirsiniz, örneğin mesaj içeriğini kontrol edebilirsiniz.
        }
    }
}