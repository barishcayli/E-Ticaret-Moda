package ETicaret.Eticaret.Service.concretes;

import ETicaret.Eticaret.Dtos.SaticiDegerlendirmeEkleDto;
import ETicaret.Eticaret.Entity.SaticiDegerlendirme;
import ETicaret.Eticaret.Observer.SaticiDegerlendirmeManager;
import ETicaret.Eticaret.Repository.SaticiDegerlendirmeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class SaticiDegerlendirmeBusinnesTest {

    @Mock
    private SaticiDegerlendirmeRepository saticiDegerlendirmeRepository;

    @Mock
    private SaticiDegerlendirmeManager saticiDegerlendirmeManager;

    @InjectMocks
    private SaticiDegerlendirmeBusinnes saticiDegerlendirmeBusinnes;

    @Captor
    private ArgumentCaptor<SaticiDegerlendirme> degerlendirmeCaptor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDegerlendirmeEkle() {
        SaticiDegerlendirmeEkleDto dto = new SaticiDegerlendirmeEkleDto(5, 1, 1);

        saticiDegerlendirmeBusinnes.degerlendirmeEkle(dto);

        verify(saticiDegerlendirmeRepository, times(1)).save(degerlendirmeCaptor.capture());
        verify(saticiDegerlendirmeManager, times(1)).notifyObservers(degerlendirmeCaptor.getValue());

        SaticiDegerlendirme captured = degerlendirmeCaptor.getValue();
        assertEquals(5, captured.getVerilenPuan());
        assertEquals(1, captured.getSaticiId());
        assertEquals(1, captured.getMusteriId());
    }

    @Test
    public void testDegerlendirmeSil() {
        int degerlendirmeId = 1;

        saticiDegerlendirmeBusinnes.degerlendirmeSil(degerlendirmeId);

        verify(saticiDegerlendirmeRepository, times(1)).deleteById(degerlendirmeId);
    }

    @Test
    public void testSaticiDegerlendirmeListele() {
        List<Integer> degerlendirmeler = Arrays.asList(5, 4, 3);
        when(saticiDegerlendirmeRepository.findBySaticiId(anyInt())).thenReturn(degerlendirmeler);

        // SaticiDegerlendirmeListele metodunun çıktısını kontrol etmek için System.out'u yakalayacağız.
        // Ancak burada metodun çağrılıp çağrılmadığını kontrol edeceğiz.
        saticiDegerlendirmeBusinnes.saticiDegerlendirmeListele(1);

        verify(saticiDegerlendirmeRepository, times(1)).findBySaticiId(1);
    }

    @Test
    public void testSaticiOrtalamasi() {        List<Integer> degerlendirmeler = Arrays.asList(4, 5, 3, 5);
        when(saticiDegerlendirmeRepository.findBySaticiId(1)).thenReturn(degerlendirmeler);


         saticiDegerlendirmeBusinnes.saticiOrtalamasi(1);

        verify(saticiDegerlendirmeRepository, times(1)).findBySaticiId(1);
    }
}
