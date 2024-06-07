package ETicaret.Eticaret.Observer;

import ETicaret.Eticaret.Entity.SaticiDegerlendirme;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaticiDegerlendirmeManager implements Subject {
    private List<Observer> observers;

    public SaticiDegerlendirmeManager() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(SaticiDegerlendirme saticiDegerlendirme) {
        for (Observer observer : observers) {
            observer.update(saticiDegerlendirme);
        }
    }
}
