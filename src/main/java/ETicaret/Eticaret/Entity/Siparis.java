package ETicaret.Eticaret.Entity;

import jakarta.persistence.*;

@Entity
@Table(name= "siparis")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "siparis_id")
    private int id;

    @Column(name="musteri_id")
    private int musteriId;

    @Column(name="urun_id")
    private int urunId;

    @Column(name="miktar")
    private String miktar;

    @Column(name="siparis_tarihi")
    private String siparis_tarihi;

    @Column(name="teslim_tarihi")
    private String teslim_tarihi;

    @Column(name="siparis_adresi")
    private String siparis_adresi;





    public Siparis(int musteriId, int urunId, String miktar, String siparis_tarihi, String teslim_tarihi, String siparis_adresi) {
        this.musteriId = musteriId;
        this.urunId = urunId;
        this.miktar = miktar;
        this.siparis_tarihi = siparis_tarihi;
        this.teslim_tarihi = teslim_tarihi;
        this.siparis_adresi = siparis_adresi;


    }
    public Siparis() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMusteriId() {
        return musteriId;

    }
    public void setMusteriId(int musteriId) {
        this.musteriId = musteriId;
    }
    public int getUrunId() {
        return urunId;
    }
    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }
    public String getMiktar() {
        return miktar;
    }
    public void setMiktar(String miktar) {
        this.miktar = miktar;

    }
    public String getSiparis_tarihi() {
        return siparis_tarihi;
    }
    public void setSiparis_tarihi(String siparis_tarihi) {
        this.siparis_tarihi = siparis_tarihi;
    }
    public String getTeslim_tarihi() {
        return teslim_tarihi;
    }
    public void setTeslim_tarihi(String teslim_tarihi) {
        this.teslim_tarihi = teslim_tarihi;
    }
    public String getSiparis_adresi() {
        return siparis_adresi;
    }
    public void setSiparis_adresi(String siparis_adresi) {
        this.siparis_adresi = siparis_adresi;
    }

    public String toString() {
        return "Siparis{" +
                "id=" + id +
                ", Musteri id='" + musteriId + '\'' +
                ", Urun id=" + urunId +
                ", miktar=" + miktar +
                ", siparis adresi= "+ siparis_adresi +
                ", Sipariş Tarihi= "+ siparis_tarihi +

                ", Teslim Tarihi= "+ teslim_tarihi+
                '}';

    }


}
