package ETicaret.Eticaret.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="satici_degerlendirme")
public class SaticiDegerlendirme {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="satici_degerlendirme_id")
    private int saticiDegerlendirme_id;

    @Column(name="verilen_puan")
    private int verilenPuan;

    @Column(name="satici_id")
    private int saticiId;

    @Column(name="musteri_id")
    private int musteriId;

    public SaticiDegerlendirme(int verilenPuan, int saticiId, int musteriId) {
        this.verilenPuan=verilenPuan;
        this.saticiId=saticiId;
        this.musteriId=musteriId;

    }




    public SaticiDegerlendirme() {

    }


    public int getSaticiDegerlendirme_id() {
        return saticiDegerlendirme_id;

    }

    public void setSaticiDegerlendirme_id(int saticiDegerlendirme_id) {
        this.saticiDegerlendirme_id = saticiDegerlendirme_id;
    }

    public int getVerilenPuan() {
        return verilenPuan;
    }

    void setVerilenPuan(int saticiDegerlendirme) {
        this.verilenPuan = saticiDegerlendirme;
    }

    public int getSaticiId() {
        return saticiId;
    }

    void setSaticiId(int saticiId) {
        this.saticiId = saticiId;
    }
    public int getMusteriId() {
        return musteriId;
    }
    void setMusteriId(int musteriId) {
        this.musteriId = musteriId;
    }

    public String toString() {
        return "{ Değerlendirme id "
        + saticiDegerlendirme_id +", Değerlendirme puanı: " +
                verilenPuan +
                ", Satıcı id"+ saticiId +
                ", Musteri id" + musteriId + "}";
    }



}
