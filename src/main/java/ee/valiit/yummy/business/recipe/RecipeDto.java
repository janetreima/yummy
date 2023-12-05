package ee.valiit.yummy.business.recipe;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link ee.valiit.yummy.domain.recipe.Recipe}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto implements Serializable {
    private Integer recipeId;
    private Integer userId;
    private Integer courseId;
    private String courseName;
    private Integer imageId;
    private String imageData;
    @NotNull
    @Size(max = 255)
    private String recipeName;
    @NotNull
    private LocalTime time;
    @NotNull
    @Size(max = 1000)
    private String description;
    @NotNull
    private String status;
}