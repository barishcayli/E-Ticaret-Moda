package ETicaret.Eticaret.Config;

import ETicaret.Eticaret.Observer.MusteriObserver;
import ETicaret.Eticaret.Observer.SaticiDegerlendirmeManager;
import ETicaret.Eticaret.Observer.SaticiObserver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObserverConfig {

    @Bean
    CommandLineRunner init(SaticiDegerlendirmeManager saticiDegerlendirmeManager) {
        return args -> {
            saticiDegerlendirmeManager.registerObserver(new SaticiObserver("satici@example.com"));
            saticiDegerlendirmeManager.registerObserver(new MusteriObserver("musteri@example.com"));
        };
    }
}
