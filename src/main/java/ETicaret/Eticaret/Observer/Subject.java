package ETicaret.Eticaret.Observer;

import ETicaret.Eticaret.Entity.SaticiDegerlendirme;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(SaticiDegerlendirme saticiDegerlendirme);
}
