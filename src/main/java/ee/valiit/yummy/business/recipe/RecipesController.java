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
    @Operation(summary = "leiab koik retseptid")
    public List<RecipeBasicDto> getAllRecipes() {
        return recipesService.getAllRecipes();

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
        // todo evgeni

    }
}
