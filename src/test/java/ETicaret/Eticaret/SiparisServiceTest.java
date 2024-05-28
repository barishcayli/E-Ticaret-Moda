package ETicaret.Eticaret;

import ETicaret.Eticaret.Dtos.SiparisEkleDto;
import ETicaret.Eticaret.Entity.Siparis;
import ETicaret.Eticaret.Repository.SiparisRepository;
import ETicaret.Eticaret.Service.abstracts.SiparisService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SiparisServiceTest {

    @Mock
    private SiparisRepository siparisRepository;

    @InjectMocks
    private SiparisService siparisService;

    @Test
    void testSiparisEkle() throws ParseException {
        // Hazırlık
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String siparisTarihi = "01-01-2024";
        String teslimTarihi = "10-01-2024";
        SiparisEkleDto siparisDto = new SiparisEkleDto(1, 1, 5, "Adres", siparisTarihi, teslimTarihi);

        // Test
        siparisService.siparisEkle(siparisDto);

        // Doğrulama
        verify(siparisRepository, times(1)).save(any(Siparis.class));
    }

    @Test
    void testSiparisSil() {
        // Hazırlık
        int siparisId = 1;

        // Test
        siparisService.siparisSil(siparisId);

        // Doğrulama
        verify(siparisRepository, times(1)).deleteById(siparisId);
    }

    @Test
    void testSiparisListele() {
        // Hazırlık
        List<Siparis> siparisList = new ArrayList<>();
        siparisList.add(new Siparis(1, 1, 5, "Adres", new Date(), new Date()));
        when(siparisRepository.findAll()).thenReturn(siparisList);

        // Test
        List<Siparis> returnedList = siparisService.siparisListele();

        // Doğrulama
        assertEquals(siparisList.size(), returnedList.size());
        for (int i = 0; i < siparisList.size(); i++) {
            assertEquals(siparisList.get(i), returnedList.get(i));
        }
    }

    @Test
    void testAdresGuncelle() {
        // Hazırlık
        int siparisId = 1;
        String yeniAdres = "Yeni Adres";
        Siparis siparis = new Siparis(1, 1, 5, "Eski Adres", new Date(), new Date());
        Optional<Siparis> siparisOptional = Optional.of(siparis);
        when(siparisRepository.findById(siparisId)).thenReturn(siparisOptional);

        // Test
        siparisService.adresGuncelle(siparisId, yeniAdres);

        // Doğrulama
        verify(siparisRepository, times(1)).findById(siparisId);
        assertEquals(yeniAdres, siparis.getSiparis_adresi());
        verify(siparisRepository, times(1)).save(siparis);
    }


}
