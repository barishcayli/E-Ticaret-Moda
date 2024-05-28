package ETicaret.Eticaret.Dtos;

import jakarta.validation.constraints.*;

public record MusteriGuncelleDto(

        @NotNull(message = "Musteri Id alanı boş olamaz")
        long musteriId,

        @NotNull(message = "Kullanıcı ad soyad alanı boş olamaz")
        @NotEmpty(message = "Kullanıcı ad soyad alanı boş olamaz")
        @NotBlank(message = "Kullanıcı ad soyad alanı boş olamaz")
        String adSoyad,
        @NotNull(message = "adres alanı boş olamaz")
        String adres,

        @Email(message = "Müşterinin txti email formatında olmalıdır.")
        String eposta,

        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$\n", message = " parolanızda \n " +
                "En az bir küçük harf içermesi gerekir. \n " +
                " En az bir büyük harf içermesi gerekir \n" +
                "En az bir rakam içermesi gerekir")
        String sifre
) {
}
