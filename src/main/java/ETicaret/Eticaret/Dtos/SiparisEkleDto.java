package ETicaret.Eticaret.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record SiparisEkleDto(

        @NotNull(message = "müşteri id boş olamaz")
        int musteriId,

        @NotNull(message = "ürün boş olamaz")
        int urunId,

        @NotNull(message = "miktar boş olamaz")
        int miktar,

        @NotNull(message = "sipariş adresi boş olamaz")
        String siparis_adresi,

        @NotNull(message = "teslim tarihi boş olamaz")
        String teslim_tarihi,

        @NotNull(message = "sipariş tarihi boş olamaz")
        String siparis_tarihi) {
}
