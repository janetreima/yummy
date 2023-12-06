package ee.valiit.yummy.business.recipe;

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

    @GetMapping("/recipe")
    @Operation(summary = "leiab ühe retsepti recipeId järgi")
    public RecipeDetailedDto getRecipe(@RequestParam Integer recipeId) {
        RecipeDetailedDto recipeDetailedDto = recipesService.getRecipe(recipeId);
        recipesService.getAllergens(recipeId);
        return recipeDetailedDto;
    }

    @PostMapping("/recipe")
    @Operation(summary = "lisab uue retsepti")
    public void addRecipe(@RequestParam Integer userId, @RequestBody RecipeDetailedDto recipeDetailedDto) {
        recipesService.addRecipe(recipeDetailedDto);
    }

    @PutMapping("/recipe")
    @Operation(summary = "muudab retsepti")
    public void editRecipe(@RequestParam Integer recipeId, @RequestBody RecipeDetailedDto recipeDetailedDto) {
        // todo evgeni
    }


}
