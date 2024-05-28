package ETicaret.Eticaret;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.Repository.SaticiRepository;
import ETicaret.Eticaret.Service.abstracts.SaticiService;
import ETicaret.Eticaret.Service.concretes.SaticiBusinnes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaticiServiceTest {

    @Mock
    private SaticiRepository saticiRepository;

    @InjectMocks
    private SaticiBusinnes saticiService;

    @Test
    void testSaticiListele() {
        // Hazırlık
        List<Satici> saticiList = new ArrayList<>();
        saticiList.add(new Satici("Ahmet Yılmaz", "Marka A", "ahmet@example.com", "123456"));
        saticiList.add(new Satici("Ayşe Kaya", "Marka B", "ayse@example.com", "654321"));
        when(saticiRepository.findAll()).thenReturn(saticiList);

        // Test
        List<Satici> returnedList = saticiService.saticiListele();

        // Doğrulama
        assertEquals(saticiList.size(), returnedList.size());
        for (int i = 0; i < saticiList.size(); i++) {
            assertEquals(saticiList.get(i), returnedList.get(i));
        }
    }

    @Test
    void testSaticiEkle() {
        // Hazırlık
        SaticiEkleDto saticiDto = new SaticiEkleDto("Ali Veli", "Marka C", "ali@example.com", "password");

        // Test
        saticiService.saticiEkle(saticiDto);

        // Doğrulama
        verify(saticiRepository, times(1)).save(any(Satici.class));
    }

    @Test
    void testSaticiSil() {
        // Hazırlık
        int saticiId = 1;

        // Test
        saticiService.saticiSil(saticiId);

        // Doğrulama
        verify(saticiRepository, times(1)).deleteById(saticiId);
    }

    @Test
    void testSaticiGuncelle() {
        // Hazırlık
        Satici satici = new Satici("Ali Veli", "Marka C", "ali@example.com", "password");
        Optional<Satici> saticiOptional = Optional.of(satici);
        when(saticiRepository.findById(any(Integer.class))).thenReturn(saticiOptional);

        // Test
        saticiService.saticiGuncelle(1, "Mehmet Veli", "Marka D", "mehmet@example.com", "newpassword");

        // Doğrulama
        verify(saticiRepository, times(1)).findById(1);
        verify(saticiRepository, times(1)).save(any(Satici.class));
    }

    // Diğer test metodları buraya eklenebilir
}
