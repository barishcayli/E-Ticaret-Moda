package ETicaret.Eticaret.Observer;

import ETicaret.Eticaret.Entity.SaticiDegerlendirme;

public class SaticiObserver implements Observer {
    private String saticiEmail;

    public SaticiObserver(String saticiEmail) {
        this.saticiEmail = saticiEmail;
    }

    @Override
    public void update(SaticiDegerlendirme saticiDegerlendirme) {
        System.out.println("Satıcıya e-posta gönderiliyor: " + saticiEmail);
        System.out.println("Yeni değerlendirme: " + saticiDegerlendirme);
    }
}