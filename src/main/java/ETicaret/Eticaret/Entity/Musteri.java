package ETicaret.Eticaret.Entity;

import jakarta.persistence.*;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name ="musteri")
public class Musteri {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name="musteri_id")
       private int id;

       @Column(name = "ad_soyad")
        private String adSoyad;

       @Column(name="adres")
        private String adres;

       @Column(name="eposta")
    private String eposta;

       @Column(name = "sifre")
    private String sifre;

       public Musteri(String adSoyad, String adres, String eposta, String sifre ) {
           this.adSoyad = adSoyad;
           this.adres = adres;
           this.eposta = eposta;
           this.sifre = sifre;
       }
       public Musteri() {}

    public int getId() {
           return id;

    }

    public void setId(int id) {
           this.id = id;
    }
    public String getAdSoyad() {
           return adSoyad;
    }
    public void setAdSoyad(String adSoyad) {
           this.adSoyad = adSoyad;

    }
    public String getAdres() {
           return adres;
    }

    public void setAdres(String adres) {
           this.adres = adres;
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
           return "musteri{"+
                   "Ad-Soyad: "+ adSoyad+
                   ", adres: "+ adres+
                   ", eposta: "+ eposta+"}";
    }

}
