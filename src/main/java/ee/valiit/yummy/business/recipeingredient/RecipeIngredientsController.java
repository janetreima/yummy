package ee.valiit.yummy.business.recipeingredient;

import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeIngredientsController {

    @Resource
    private RecipeIngredientsService recipeIngredientsService;

    @PostMapping("/recipe/ingredient")
    @Operation(summary = "lisab retsepti koostisosad")
    public void addRecipeIngredient(@RequestParam Integer recipeId, @RequestBody RecipeIngredientRequest recipeIngredientRequest) {
        recipeIngredientsService.addRecipeIngredient(recipeId, recipeIngredientRequest);
    }
}
