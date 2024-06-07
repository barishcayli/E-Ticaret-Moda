
package ETicaret.Eticaret.Observer;

import ETicaret.Eticaret.Entity.SaticiDegerlendirme;

public class MusteriObserver implements Observer {
    private String musteriEmail;

    public MusteriObserver(String musteriEmail) {
        this.musteriEmail = musteriEmail;
    }

    @Override
    public void update(SaticiDegerlendirme saticiDegerlendirme) {
        System.out.println("Müşteriye e-posta gönderiliyor: " + musteriEmail);
        System.out.println("Değerlendirmeniz için teşekkürler: " + saticiDegerlendirme);
    }
}