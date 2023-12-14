package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.recipe.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipesController {

    @Resource
    private RecipesService recipesService;

    @GetMapping("/recipes")
    @Operation(summary = "leiab kõik aktiivsed retseptid")
    public List<RecipeBasicDto> getAllActiveRecipes() {
        return recipesService.getAllActiveRecipes();
    }

    @PostMapping("/recipes/filtered")
    @Operation(summary = "leiab retseptid filtri järgi")
    public List<RecipeBasicDto> getFilteredRecipes(@RequestBody FilteredRecipesRequest filteredRecipesRequest) {
        return recipesService.getFilteredRecipes(filteredRecipesRequest);
    }

    @GetMapping("/recipe")
    @Operation(summary = "leiab ühe retsepti recipeId järgi")
    public RecipeDetailedDto getRecipe(@RequestParam Integer recipeId) {
        return recipesService.getRecipeBy(recipeId);
    }

    @GetMapping("/recipes/myrecipes")
    @Operation(summary = "leiab ühe kasutaja kõik retseptid userId järgi")
    public List<RecipeBasicDto> getUserRecipes(@RequestParam Integer userId) {
        return recipesService.getUserRecipes(userId);
    }

    @PostMapping("/recipe")
    @Operation(summary = "lisab uue retsepti")
    public RecipeIdInfo addRecipe(@RequestParam Integer userId, @RequestBody RecipeRequest recipeRequest) {
        return recipesService.addRecipe(userId, recipeRequest);
    }

    @PutMapping("/recipe")
    @Operation(summary = "muudab retsepti")
    public void editRecipe(@RequestParam Integer recipeId, @RequestBody RecipeRequest recipeRequest) {
        recipesService.editRecipe(recipeId, recipeRequest);
    }

    @DeleteMapping("/recipe")
    @Operation(summary = "kustutab retsepti")
    public void deleteRecipe(@RequestParam Integer recipeId) {
        recipesService.deleteRecipe(recipeId);
    }
}
