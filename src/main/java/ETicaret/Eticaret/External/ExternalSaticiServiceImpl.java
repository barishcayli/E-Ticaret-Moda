package ETicaret.Eticaret.External;

import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ExternalSaticiServiceImpl implements ExternalSaticiService {

    private final List<Satici> sellers = new ArrayList<>();

    @Override
    public List<Satici> getAllSellers() {
        return new ArrayList<>(sellers);
    }

    @Override
    public void addSeller(SaticiEkleDto dto) {
        Satici satici = new Satici(dto.getAdSoyad(), dto.getMarkaAdi(), dto.getEposta(), dto.getSifre());
        sellers.add(satici);
    }

    @Override
    public void removeSeller(int id) {
        sellers.removeIf(seller -> Objects.equals(seller.getId(), id));
    }

    @Override
    public void updateSeller(Integer id, String adSoyad, String marka, String eposta, String sifre) {
        for (Satici satici : sellers) {
            if (Objects.equals(satici.getId(), id)) {
                satici.setAd_soyad(adSoyad);
                satici.setMarka_adi(marka);
                satici.setEposta(eposta);
                satici.setSifre(sifre);
                break;
            }
        }
    }
}
