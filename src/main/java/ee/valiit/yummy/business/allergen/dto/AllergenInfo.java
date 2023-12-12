package ee.valiit.yummy.business.allergen.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AllergenInfo {
    private Integer allergenId;
    private String allergenName;
    @NotNull
    private Boolean isAvailable;
}
