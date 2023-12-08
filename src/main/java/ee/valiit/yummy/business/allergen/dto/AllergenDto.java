package ee.valiit.yummy.business.allergen.dto;

import lombok.Data;

@Data
public class AllergenDto {
    private Integer allergenId;
    private String allergenName;
    private Boolean isaAvailable;
}
