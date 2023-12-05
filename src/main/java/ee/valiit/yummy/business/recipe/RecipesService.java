package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.RecipeMapper;
import ee.valiit.yummy.domain.recipe.RecipeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesService {

    @Resource
    private RecipeService recipeService;

    @Resource
    private RecipeMapper recipeMapper;

    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

}
