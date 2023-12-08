package ee.valiit.yummy.business.recipeingredient;


import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredient;
import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredientMapper;
import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredientService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientsService {

    @Resource
    private RecipeIngredientService recipeIngredientService;

    @Resource
    private RecipeIngredientMapper recipeIngredientMapper;

    public List<RecipeIngredientDto> getRecipeIngredientsBy(Integer recipeId) {
        List<RecipeIngredient> recipeIngredients = recipeIngredientService.getRecipeIngredientsBy(recipeId);
        return recipeIngredientMapper.toRecipeIngredientDtos(recipeIngredients);
    }
}

