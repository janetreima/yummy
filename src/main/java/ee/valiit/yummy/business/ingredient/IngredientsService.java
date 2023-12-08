package ee.valiit.yummy.business.ingredient;

import ee.valiit.yummy.domain.recipe.ingredient.Ingredient;
import ee.valiit.yummy.domain.recipe.ingredient.IngredientService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {

    @Resource
    private IngredientService ingredientService;

    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }
}
