package ETicaret.Eticaret.Observer;

import ETicaret.Eticaret.Entity.SaticiDegerlendirme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ObserverPatternTest {

    private SaticiDegerlendirmeManager saticiDegerlendirmeManager;
    private SaticiObserver saticiObserver;
    private MusteriObserver musteriObserver;

    @BeforeEach
    public void setUp() {
        saticiDegerlendirmeManager = new SaticiDegerlendirmeManager();
        saticiObserver = mock(SaticiObserver.class);
        musteriObserver = mock(MusteriObserver.class);
        saticiDegerlendirmeManager.registerObserver(saticiObserver);
        saticiDegerlendirmeManager.registerObserver(musteriObserver);
    }

    @Test
    public void testNotifyObservers() {
        SaticiDegerlendirme degerlendirme = new SaticiDegerlendirme(5, 1, 1);

        saticiDegerlendirmeManager.notifyObservers(degerlendirme);

        verify(saticiObserver, times(1)).update(degerlendirme);
        verify(musteriObserver, times(1)).update(degerlendirme);
    }

    @Test
    public void testRegisterObserver() {
        Observer yeniObserver = mock(Observer.class);
        saticiDegerlendirmeManager.registerObserver(yeniObserver);

        SaticiDegerlendirme degerlendirme = new SaticiDegerlendirme(5, 1, 1);
        saticiDegerlendirmeManager.notifyObservers(degerlendirme);

        verify(yeniObserver, times(1)).update(degerlendirme);
    }

    @Test
    public void testRemoveObserver() {
        saticiDegerlendirmeManager.removeObserver(musteriObserver);

        SaticiDegerlendirme degerlendirme = new SaticiDegerlendirme(5, 1, 1);
        saticiDegerlendirmeManager.notifyObservers(degerlendirme);

        verify(saticiObserver, times(1)).update(degerlendirme);
        verify(musteriObserver, times(0)).update(degerlendirme);
    }
}
