package ETicaret.Eticaret.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="satici")
public class Satici {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)// sütunun serial oldugunu gösterir.
    @Column(name ="satici_id")
    private int id;

    @Column(name="ad_soyad")
    private String ad_soyad;

    @Column(name="marka_adi")
    private String marka_adi;

    @Column(name="eposta")
    private String eposta;

    @Column(name="sifre")
    private String sifre;

    public Satici(String ad_soyad, String marka_adi, String eposta, String sifre) {
        this.ad_soyad = ad_soyad;
        this.marka_adi = marka_adi;
        this.eposta = eposta;
        this.sifre = sifre;

    }
    public Satici(){}

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd_soyad() {
        return ad_soyad;

    }
    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }
    public String getMarka_adi() {
        return marka_adi;
    }

    public void setMarka_adi(String marka_adi) {
        this.marka_adi = marka_adi;

    }
    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }
    public String getSifre() {
        return sifre;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String toString(){
        return "Satici"+
                "id"+id
                +"ad_soyad"+ad_soyad
                +"marka_adi"+marka_adi
                +"eposta"+eposta
                +"sifre"+sifre;

    }

}
