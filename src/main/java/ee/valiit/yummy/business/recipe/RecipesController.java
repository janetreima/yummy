package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.recipe.dto.FilteredRecipesRequest;
import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipesController {

    @Resource
    private RecipesService recipesService;

    @GetMapping("/recipes")
    @Operation(summary = "leiab kõik retseptid")
    public List<RecipeBasicDto> getAllRecipes() {
        return recipesService.getAllRecipes();
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

    @GetMapping("/recipe/filtered")
    @Operation(summary = "leiab retseptid filtri järgi")
    public List<RecipeBasicDto> getFilteredRecipes(@RequestParam Integer courseId) {
        return recipesService.getFilteredRecipes(courseId);
    }

    @PostMapping("/recipe")
    @Operation(summary = "lisab uue retsepti")
    public void addRecipe(@RequestParam Integer userId, @RequestBody RecipeDetailedDto recipeDetailedDto) {
        recipesService.addRecipe(userId, recipeDetailedDto);
    }

    @PutMapping("/recipe")
    @Operation(summary = "muudab retsepti")
    public void editRecipe(@RequestParam Integer recipeId, @RequestBody RecipeDetailedDto recipeDetailedDto) {


        recipesService.editRecipe(recipeId, recipeDetailedDto);
    }
}
