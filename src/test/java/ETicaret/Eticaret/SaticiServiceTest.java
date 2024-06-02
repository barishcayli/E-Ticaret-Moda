package ETicaret.Eticaret;

import ETicaret.Eticaret.Adapter.SaticiServiceAdapter;
import ETicaret.Eticaret.Dtos.SaticiEkleDto;
import ETicaret.Eticaret.Entity.Satici;
import ETicaret.Eticaret.External.ExternalSaticiService;
import ETicaret.Eticaret.Service.abstracts.SaticiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SaticiServiceAdapterTest {

    @Mock
    private ExternalSaticiService externalSellerService;

    @InjectMocks
    private SaticiServiceAdapter saticiServiceAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saticiListele() {
        // Arrange
        Satici satici1 = new Satici("Ad Soyad 1", "Marka 1", "eposta1@example.com", "sifre1");
        Satici satici2 = new Satici("Ad Soyad 2", "Marka 2", "eposta2@example.com", "sifre2");
        List<Satici> saticiList = Arrays.asList(satici1, satici2);
        when(externalSellerService.getAllSellers()).thenReturn(saticiList);

        // Act
        List<Satici> result = saticiServiceAdapter.saticiListele();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Ad Soyad 1", result.get(0).getAd_soyad());
        assertEquals("Ad Soyad 2", result.get(1).getAd_soyad());
    }

    @Test
    void saticiEkle() {
        // Arrange
        SaticiEkleDto dto = new SaticiEkleDto();
        dto.setad_soyad("Ad Soyad");
        dto.setmarka_adi("Marka Adı");
        dto.setEposta("eposta@example.com");
        dto.setSifre("sifre");

        // Act
        saticiServiceAdapter.saticiEkle(dto);

        // Assert
        verify(externalSellerService, times(1)).addSeller(any(SaticiEkleDto.class));
    }

    @Test
    void saticiSil() {
        // Arrange
        int id = 1;

        // Act
        saticiServiceAdapter.saticiSil(id);

        // Assert
        verify(externalSellerService, times(1)).removeSeller(id);
    }

    @Test
    void saticiGuncelle() {
        // Arrange
        int id = 1;
        String adSoyad = "Yeni Ad Soyad";
        String markaAdi = "Yeni Marka Adı";
        String eposta = "yeni_eposta@example.com";
        String sifre = "yeni_sifre";

        // Act
        saticiServiceAdapter.saticiGuncelle(id, adSoyad, markaAdi, eposta, sifre);

        // Assert
        verify(externalSellerService, times(1)).updateSeller(id, adSoyad, markaAdi, eposta, sifre);
    }
}
