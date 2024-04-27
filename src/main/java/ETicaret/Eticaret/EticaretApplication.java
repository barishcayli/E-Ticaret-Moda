package ETicaret.Eticaret;

import ETicaret.Eticaret.Service.UrunService;
import ETicaret.Eticaret.Service.MusteriService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EticaretApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EticaretApplication.class, args);
		UrunService fun =context.getBean(UrunService.class);
        MusteriService funmusteri =context.getBean(MusteriService.class);


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








    }
}
