package ETicaret.Eticaret.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="urun")
public class Urun{
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

    public Urun(String urunAdi, int stokMiktari, double fiyat) {
        this.urunAdi = urunAdi;
        this.stokMiktari = stokMiktari;
        this.fiyat = fiyat;
    }

    public Urun() {

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
