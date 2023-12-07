package ee.valiit.yummy.domain.recipe.recipeingredient;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {

    @Resource
    private RecipeIngredientRepository recipeIngredientRepository;

    public List<RecipeIngredient> getRecipeIngredientsBy(Integer recipeId) {
        return recipeIngredientRepository.getRecipeIngredientsBy(recipeId);
    }
}