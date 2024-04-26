package ETicaret.Eticaret;

import ETicaret.Eticaret.Service.UrunService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EticaretApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EticaretApplication.class, args);
		UrunService fun =context.getBean(UrunService.class);


/*
        fun.UrunEkle("öylesine",21,32);
        fun.UrunSil(23);
        fun.urunGuncelle(29,"deneme",21,213);
		fun.UrunSat(29,10);


 */
		fun.UrunListele();




    }
}
