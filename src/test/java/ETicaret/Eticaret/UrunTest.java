package ETicaret.Eticaret;

import ETicaret.Eticaret.Entity.Urun;
import ETicaret.Eticaret.Observer.Observer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UrunTest {

    @Test
    void testRegisterObserver() {
        // Arrange
        Urun urun = new Urun();
        Observer observer = Mockito.mock(Observer.class);

        // Act
        urun.registerObserver(observer);

        // Assert
        Mockito.verify(observer).update(Mockito.anyString());
    }

    @Test
    void testRemoveObserver() {
        // Arrange
        Urun urun = new Urun();
        Observer observer = Mockito.mock(Observer.class);
        urun.registerObserver(observer);

        // Act
        urun.removeObserver(observer);

        // Assert
        Mockito.verify(observer, Mockito.never()).update(Mockito.anyString());
    }

    @Test
    void testNotifyObservers() {
        // Arrange
        Urun urun = new Urun();
        Observer observer = Mockito.mock(Observer.class);
        urun.registerObserver(observer);

        // Act
        urun.notifyObservers("Test message");

        // Assert
        Mockito.verify(observer).update("Test message");
    }
}
