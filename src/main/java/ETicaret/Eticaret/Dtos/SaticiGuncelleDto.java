package ETicaret.Eticaret.Dtos;

public class SaticiGuncelleDto {
    private int id;
    private String adSoyad;
    private String markaAdi;
    private String eposta;
    private String sifre;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAdSoyad() {
        return adSoyad;
    }

    public void setad_soyad(String ad_soyad) {
        this.adSoyad = ad_soyad;
    }

    public String getMarkaAdi() {
        return markaAdi;
    }

    public void setmarka_adi(String markaAdi) {
        this.markaAdi = markaAdi;
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
}
