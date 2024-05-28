package ETicaret.Eticaret;

import ETicaret.Eticaret.Dtos.MusteriEkleDto;
import ETicaret.Eticaret.Dtos.MusteriGuncelleDto;
import ETicaret.Eticaret.Entity.Musteri;
import ETicaret.Eticaret.Repository.MusteriRepository;
import ETicaret.Eticaret.Service.abstracts.MusteriService;
import ETicaret.Eticaret.Service.concretes.MusteriBusinnes;
import ETicaret.Eticaret.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MusteriServiceTest {

    @Mock
    private MusteriRepository musteriRepository;

    @InjectMocks
    private MusteriBusinnes musteriService;

    @Test
    void testMusteriListele() {
        // Hazırlık
        List<Musteri> musteriList = new ArrayList<>();
        musteriList.add(new Musteri("Ahmet Yılmaz", "İstanbul", "ahmet@example.com", "123456"));
        musteriList.add(new Musteri("Ayşe Kaya", "Ankara", "ayse@example.com", "654321"));
        when(musteriRepository.findAll()).thenReturn(musteriList);

        // Test
        List<Musteri> returnedList = musteriService.musteriListele();

        // Doğrulama
        assertEquals(musteriList.size(), returnedList.size());
        for (int i = 0; i < musteriList.size(); i++) {
            assertEquals(musteriList.get(i), returnedList.get(i));
        }
    }

    @Test
    void testMusteriEkle() {
        // Hazırlık
        MusteriEkleDto musteriDto = new MusteriEkleDto("Ali Veli", "İzmir", "ali@example.com", "password");

        // Test
        musteriService.musteriEkle(musteriDto);

        // Doğrulama
        verify(musteriRepository, times(1)).save(any(Musteri.class));
    }

    @Test
    void testMusteriSil() {
        // Hazırlık
        int musteriId = 1;

        // Test
        musteriService.musteriSil(musteriId);

        // Doğrulama
        verify(musteriRepository, times(1)).deleteById(musteriId);
    }

    @Test
    void testMusteriGuncelle() throws NotFoundException {
        // Hazırlık
        MusteriEkleDto musteriDto = new MusteriEkleDto("Ali Veli", "İzmir", "ali@example.com", "password");
        Musteri musteri = new Musteri("Ali Veli", "İzmir", "ali@example.com", "password");
        Optional<Musteri> musteriOptional = Optional.of(musteri);
        when(musteriRepository.findById(any(Integer.class))).thenReturn(musteriOptional);

        // Test
        musteriService.musteriGuncelle(new MusteriGuncelleDto(1, "Mehmet Veli", "Ankara", "mehmet@example.com", "newpassword"));

        // Doğrulama
        verify(musteriRepository, times(1)).findById(1);
        verify(musteriRepository, times(1)).save(any(Musteri.class));
    }

    @Test
    void testMusteriListeleBosListe() {
        // Hazırlık
        when(musteriRepository.findAll()).thenReturn(new ArrayList<>());

        // Test
        List<Musteri> returnedList = musteriService.musteriListele();

        // Doğrulama
        assertTrue(returnedList.isEmpty());
    }

    @Test
    void testMusteriEkleHataDurumu() {
        // Hazırlık
        MusteriEkleDto musteriDto = new MusteriEkleDto(null, null, null, null);

        // Test ve Doğrulama
        assertThrows(IllegalArgumentException.class, () -> musteriService.musteriEkle(musteriDto));
        verifyNoInteractions(musteriRepository);
    }

/*
    @Test
    void testMusteriSilMusteriBulunamadi() {
        // Hazırlık
        when(musteriRepository.findById(any(Integer.class))).thenReturn(Optional.empty());

        // Test ve Doğrulama
        assertDoesNotThrow(() -> musteriService.musteriSil(1));
        verify(musteriRepository, never()).deleteById(any(Integer.class));
    }
*/

    @Test
    void testMusteriGuncelleMusteriBulunamadi() {
        // Hazırlık
       // when(musteriRepository.findById(any(Integer.class))).thenReturn(Optional.empty());

        // Test ve Doğrulama
        assertThrows(NotFoundException.class,() -> musteriService.musteriGuncelle(new MusteriGuncelleDto(1, "Ad", "Adres", "eposta@example.com", "sifre")));
        verify(musteriRepository, never()).save(any(Musteri.class));
    }}

