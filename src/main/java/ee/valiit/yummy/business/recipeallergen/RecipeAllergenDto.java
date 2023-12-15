package ee.valiit.yummy.business.recipeallergen;

import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergen;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link RecipeAllergen}
 */
@Value
public class RecipeAllergenDto implements Serializable {

    Integer allergenId;
    String allergenName;
    Boolean isAvailable;
}
