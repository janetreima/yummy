package ee.valiit.yummy.business.recipe.dto;

import ee.valiit.yummy.business.recipeallergen.RecipeAllergenDto;
import ee.valiit.yummy.business.recipeingredient.RecipeIngredientDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link ee.valiit.yummy.domain.recipe.Recipe}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDetailedResponseDto implements Serializable {

    @NotNull
    @Size(max = 255)
    private String recipeName;
    private Integer courseId;
    private List<RecipeAllergenDto> allergenInfos;
    private Integer timeMinute;
    private String description;
    private String imageData;
    private List<RecipeIngredientDto> ingredientInfos;
}