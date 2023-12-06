package ee.valiit.yummy.business.recipe.dto;

import lombok.Data;

@Data
public class AllergenDto {
    private Integer allergenId;
    private String allergenName;
    private Boolean isaAvailable;
}
