package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.recipe.dto.FilteredRecipesRequest;
import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
import ee.valiit.yummy.business.recipe.dto.RecipeIdInfo;
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
    public RecipeIdInfo addRecipe(@RequestParam Integer userId, @RequestBody RecipeDetailedDto recipeDetailedDto) {
        return recipesService.addRecipe(userId, recipeDetailedDto);
    }

    @PutMapping("/recipe")
    @Operation(summary = "muudab retsepti")
    public void editRecipe(@RequestParam Integer recipeId, @RequestBody RecipeDetailedDto recipeDetailedDto) {
        recipesService.editRecipe(recipeId, recipeDetailedDto);
    }

    @DeleteMapping("/recipe")
    @Operation(summary = "kustutab retsepti")
    public void deleteRecipe(@RequestParam Integer recipeId) {
        recipesService.deleteRecipe(recipeId);
    }
}
