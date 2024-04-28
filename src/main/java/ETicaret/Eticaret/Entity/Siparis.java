

package ETicaret.Eticaret.Entity;

import jakarta.persistence.*;
import org.springframework.format.datetime.DateFormatter;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name= "siparis")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "siparis_id")
    private long id;

    @Column(name="musteri_id")
    private int musteriId;

    @Column(name="urun_id")
    private int urunId;

    @Column(name="adet")
    private int miktar;

    @Column(name="siparis_adresi")
    private String siparis_adresi;

    @Column(name="siparis_tarihi")
    private Date siparis_tarihi;

    @Column(name="teslim_tarihi")
    private Date teslim_tarihi;






    public Siparis(int musteriId, int urunId, int miktar, String siparis_adresi,Date siparis_tarihi, Date teslim_tarihi) {

        this.musteriId = musteriId;
        this.urunId = urunId;
        this.miktar = miktar;
        this.siparis_adresi = siparis_adresi;
        this.siparis_tarihi = siparis_tarihi;
        this.teslim_tarihi = teslim_tarihi;



    }
    public Siparis() {}

    public long getId() {

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
    public int getMiktar() {

        return miktar;
    }
    public void setMiktar(int miktar) {
        this.miktar = miktar;

    }
       public String getSiparis_adresi() {

        return siparis_adresi;
    }
    public void setSiparis_adresi(String siparis_adresi) {

        this.siparis_adresi = siparis_adresi;
    }
    public Date getSiparis_tarihi() {

        return siparis_tarihi;
    }
    public void setSiparis_tarihi(Date siparis_tarihi) {

        this.siparis_tarihi = siparis_tarihi;
    }
    public Date getTeslim_tarihi() {
        return teslim_tarihi;
    }
    public void setTeslim_tarihi(Date teslim_tarihi) {

        this.teslim_tarihi = teslim_tarihi;
    }


    public String toString() {
        return "Siparis{" +
                "id=" + id +
                ", Musteri id= '" + musteriId +
                ", Urun id= " + urunId +
                ", miktar= " + miktar +
                ", siparis adresi= "+ siparis_adresi +
                ", Sipariş Tarihi= "+ siparis_tarihi +
                ", Teslim Tarihi= "+ teslim_tarihi+
                '}';

    }


}
