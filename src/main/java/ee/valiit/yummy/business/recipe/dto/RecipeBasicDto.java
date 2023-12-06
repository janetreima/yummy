package ee.valiit.yummy.business.recipe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.yummy.domain.recipe.Recipe}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeBasicDto implements Serializable {
    private Integer recipeId;
    private Integer authorUserId;
    private String authorUsername;
    private String imageData;
    private String recipeName;
    private Integer timeMinute;
}