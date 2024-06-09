package ETicaret.Eticaret.Entity;

import ETicaret.Eticaret.Observer.Observer;
import ETicaret.Eticaret.Observer.Subject;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="urun")
public class Urun implements Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="urun_id")
    private int id;

    @Column(name = "urun_adi")
    private String urunAdi;

    @Column(name="stok_miktari")
    private int stokMiktari;

    @Column(name="fiyat")
    private double fiyat;

     @Transient
    private List<Observer> observers = new ArrayList<>();

    public Urun(String urunAdi, int stokMiktari, double fiyat) {
        this.urunAdi = urunAdi;
        this.stokMiktari = stokMiktari;
        this.fiyat = fiyat;
    }

    public Urun() {

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
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public int getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(int stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
        notifyObservers("Ürünümüz olan " + urunAdi + " fiyatı " + fiyat + " olarak değişmiştir");
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", urunAdi='" + urunAdi + '\'' +
                ", stokMiktari=" + stokMiktari +
                ", fiyat=" + fiyat +
                '}';
    }
}
