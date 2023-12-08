package ee.valiit.yummy.domain.recipe.recipeallergen;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeAllergenService {

    @Resource
    private RecipeAllergenRepository recipeAllergenRepository;

public List<RecipeAllergen> findRecipeAllergensBy(Integer recipeId) {
    return recipeAllergenRepository.findRecipeAllergensByRecipeId(recipeId);
}
}
