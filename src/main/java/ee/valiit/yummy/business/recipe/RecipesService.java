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

    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipeMapper.toRecipeDtos(recipes);
    }


    public Recipe addRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.toRecipe(recipeDto);
        return recipe;
    }
}
