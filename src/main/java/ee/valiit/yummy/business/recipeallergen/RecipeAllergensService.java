package ee.valiit.yummy.business.recipeallergen;

import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergen;
import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergenMapper;
import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipeAllergensService {

    @Resource
    private RecipeAllergenService recipeAllergenService;

    @Resource
    private RecipeAllergenMapper recipeAllergenMapper;

    public List<RecipeAllergenDto> getRecipeAllergenDtosBy(Integer recipeId) {
        List<RecipeAllergen> recipeAllergens = recipeAllergenService.findRecipeAllergensBy(recipeId);
        return recipeAllergenMapper.toRecipeAllergenDtos(recipeAllergens);
    }

}
