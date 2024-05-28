package ETicaret.Eticaret.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record SaticiEkleDto (

        @NotNull(message = "Ad soyad boş olamaz")
        String ad_soyad,

        @NotNull(message = "Marka adı boş olamaz")
        String marka_adi,

        @Email(message = "E-posta boş olamaz")
        String eposta,

        @NotNull(message = "Şifre boş olamaz")
        String sifre
){
}
