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

    public List<RecipeBasicDto> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipeMapper.toRecipeBasicDto(recipes);
    }


    public Recipe addRecipe(RecipeBasicDto recipeBasicDto) {
        Recipe recipe = recipeMapper.toRecipe(recipeBasicDto);
        return recipe;
    }
}
