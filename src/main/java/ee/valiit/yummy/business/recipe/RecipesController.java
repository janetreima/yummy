package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.RecipeMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipesController {

    @Resource
    private RecipesService recipesService;

    @Resource
    private RecipeMapper recipeMapper;

    @GetMapping("/recipe")
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = recipesService.getAllRecipes();
        return recipeMapper.toRecipeDtos(recipes);

    }
}
