package ee.valiit.yummy.business.recipeingredient;

import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeIngredientsController {

    @Resource
    private RecipeIngredientsService recipeIngredientsService;

    @GetMapping("/recipe/ingredients")
    @Operation(summary = "tagastab ühe retsepti kõik koostisosad recipeId järgi")
    public List<RecipeIngredientDto> getRecipeIngredientsBy(@RequestParam Integer recipeId) {
        return recipeIngredientsService.getRecipeIngredientsBy(recipeId);
    }

    @PostMapping("/recipe/ingredient")
    @Operation(summary = "lisab retsepti koostisosad")
    public void addRecipeIngredient(@RequestParam Integer recipeId, @RequestBody RecipeIngredientRequest recipeIngredientRequest) {
        recipeIngredientsService.addRecipeIngredient(recipeId, recipeIngredientRequest);
    }

}
