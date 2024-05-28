package ETicaret.Eticaret.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public record SaticiDegerlendirmeEkleDto (

    @NotNull(message ="Puan verilmelidir")
     int verilenPuan,
    @NotNull(message = "Satıcı seçilmeli")
     int saticiId,
    @NotNull(message = "Değerlendirme için bir hesabınız olmalıdır")
     int musteriId
){

}
