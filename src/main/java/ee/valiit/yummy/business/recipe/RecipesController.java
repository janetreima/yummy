package ee.valiit.yummy.business.recipe;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @Operation(summary = "liisab uut retsepti")
    public void addRecipe(@RequestBody RecipeBasicDto recipeBasicDto) {
        recipesService.addRecipe(recipeBasicDto);
    }

}
