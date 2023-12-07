package ee.valiit.yummy.business.recipeingredient;

import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link RecipeIngredient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDto implements Serializable {
    private Integer recipeId;
    private Integer ingredientId;
    private String ingredientName;
    private Integer measureUnitId;
    private String measureUnitName;
}