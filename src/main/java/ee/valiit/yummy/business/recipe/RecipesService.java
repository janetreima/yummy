package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedResponseDto;
import ee.valiit.yummy.business.recipeallergen.RecipeAllergenDto;
import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.RecipeMapper;
import ee.valiit.yummy.domain.recipe.RecipeService;
import ee.valiit.yummy.domain.recipe.allergen.AllergenService;
import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergen;
import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergenMapper;
import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesService {

    @Resource
    private RecipeService recipeService;

    @Resource
    private AllergenService allergenService;

    @Resource
    private RecipeAllergenService recipeAllergenService;

    @Resource
    private RecipeMapper recipeMapper;

    @Resource
    private RecipeAllergenMapper recipeAllergenMapper;

    public List<RecipeBasicDto> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipeMapper.toRecipeBasicDto(recipes);
    }

    public RecipeDetailedResponseDto getRecipe(Integer recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        RecipeDetailedResponseDto recipeDetailedResponseDto = recipeMapper.toRecipeDetailedResponseDto(recipe);
        getAndSetRecipeAllergens(recipeId, recipeDetailedResponseDto);
        return recipeDetailedResponseDto;
    }

    private void getAndSetRecipeAllergens(Integer recipeId, RecipeDetailedResponseDto recipeDetailedResponseDto) {
        List<RecipeAllergen> recipeAllergens = recipeAllergenService.findRecipeAllergensBy(recipeId);
        List<RecipeAllergenDto> recipeAllergenDtos = recipeAllergenMapper.toRecipeAllergenDtos(recipeAllergens);
        recipeDetailedResponseDto.setAllergenInfos(recipeAllergenDtos);
    }

    public Recipe addRecipe(RecipeDetailedDto recipeBasicDto) {
//        Recipe recipe = recipeMapper.toRecipe(recipeBasicDto);
        return null;
    }
}


