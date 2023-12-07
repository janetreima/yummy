package ee.valiit.yummy.business.recipeingredient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredient}
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
    private Double quantity;
}