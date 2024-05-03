package ETicaret.Eticaret;

import ETicaret.Eticaret.Service.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EticaretApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EticaretApplication.class, args);
		UrunService fun =context.getBean(UrunService.class);
        MusteriService funmusteri =context.getBean(MusteriService.class);
        SiparisService funsiparis = context.getBean(SiparisService.class);
        SaticiService funsatici =context.getBean(SaticiService.class);
        SaticiDegerlendirmeService funDegerlendirme = context.getBean(SaticiDegerlendirmeService.class);

        /* URUN FUN
        fun.UrunEkle("öylesine",21,32);
        fun.UrunSil(23);
        fun.urunGuncelle(29,"deneme",21,213);
		fun.UrunSat(29,10);

		fun.UrunListele();


 */ //URUN FUN
        /*
        funmusteri.MusteriEkle("Barış Çaylı","mevlanam mahallesi 742.sokak","barscayli@gmail.com","123456");

        funmusteri.MusteriSil(1);
        funmusteri.MusteriGuncelle(11,"Barış Çaylı", "Mevlana Mahallesi 742. Sokak","barscayli@gmail.com","987654");
        funmusteri.MusteriListele();


*/ //MUSTERI FUN
        /*
        funsiparis.SiparisEkle(7	,2,	5,
                "Atatürk Bulvarı No:22, Alsancak, İzmir",
                "12-11-2021","21-12-2021" );


        funsiparis.SiparisSil(254);
        funsiparis.AdresGuncelle(250,"mevlana mahallesi 742. sokak no 18 , Atakum, Samsun");
        funsiparis.SiparisListele();



        */ //SIPARIS FUN
/*
        funsatici.SaticiListele();

*/
        /*
        funDegerlendirme.saticiDegerlendirmeListele(2);
*/
        funDegerlendirme.SaticiOrtalaması(2);
        funDegerlendirme.DegerlendirmeEkle(3,3,2);






    }
}
