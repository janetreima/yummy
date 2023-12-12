package ee.valiit.yummy.business.recipeingredient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientRequest implements Serializable {
    private String ingredientName;
    private Integer measureUnitId;
    private BigDecimal quantity;
}