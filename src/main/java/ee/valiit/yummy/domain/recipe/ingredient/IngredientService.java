package ee.valiit.yummy.domain.recipe.ingredient;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Resource
    private IngredientRepository ingredientRepository;


    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
