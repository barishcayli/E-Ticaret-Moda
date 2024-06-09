package ETicaret.Eticaret.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public record UrunEkleDto(
    @NotNull(message = "ürün adı boş olamaz")
    String urunAdi,

    @NotNull(message = "Stok miktarı girilmelidir")
    int stokMiktari,

    @NotNull(message = "ürün fiyatı boş olamaz")
    double fiyat){
}
