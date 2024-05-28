package ETicaret.Eticaret.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record MusteriEkleDto(

        @NotNull(message = "Kullanıcı ad soyad alanı boş olamaz")
        String adSoyad,
        @NotNull(message = "adres alanı boş olamaz")
        String adres,

        @Email(message = "Müşterinin txti email formatında olmalıdır.")
        String eposta,
        @NotNull(message = "Şifre boş olamaz")
        String sifre
) {
}
