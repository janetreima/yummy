package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
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

    public RecipeDetailedDto getRecipe(Integer recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        return recipeMapper.toRecipeDetailedDto(recipe);
    }

    public Recipe addRecipe(RecipeDetailedDto recipeBasicDto) {
//        Recipe recipe = recipeMapper.toRecipe(recipeBasicDto);
        return null;
    }

    public void getAllergens(Integer recipeId) {
// todo tuleb kätte saada list allergeenidest List<AllergenDto> ja panna see RecipeDetailedDtosse.
    }
}


