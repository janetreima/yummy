package ee.valiit.yummy.domain.recipe.recipeallergen;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeAllergenService {

    @Resource
    private RecipeAllergenRepository recipeAllergenRepository;

public List<RecipeAllergen> findRecipeAllergensBy(Integer recipeId) {
    return recipeAllergenRepository.findRecipeAllergensByRecipeId(recipeId);
}

    public Boolean recipeExistsBy(Integer recipeId, List<Integer> allergenIds) {
        Optional<Boolean> optionalBoolean = recipeAllergenRepository.existsBy(recipeId, allergenIds, allergenIds.size());
        if (optionalBoolean.isEmpty()) {
            return false;
        }
        return optionalBoolean.get();
    }
}
