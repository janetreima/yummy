package ee.valiit.yummy.business.recipeallergen;

import ee.valiit.yummy.business.allergen.AllergensService;
import ee.valiit.yummy.business.allergen.dto.AllergenInfo;
import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.RecipeService;
import ee.valiit.yummy.domain.recipe.allergen.Allergen;
import ee.valiit.yummy.domain.recipe.allergen.AllergenService;
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

    @Resource
    private RecipeService recipeService;

    @Resource
    private AllergenService allergenService;



    public List<RecipeAllergenDto> getRecipeAllergenDtosBy(Integer recipeId) {
        List<RecipeAllergen> recipeAllergens = recipeAllergenService.findRecipeAllergensBy(recipeId);
        return recipeAllergenMapper.toRecipeAllergenDtos(recipeAllergens);
    }

    public void addAllergensToRecipe(Integer recipeId, List<AllergenInfo> allergenInfos) {
        Recipe recipe = recipeService.getRecipeBy(recipeId);

        for (AllergenInfo allergenInfo : allergenInfos) {
           // for tsykkel

            if (allergenInfo.getIsAvailable()){
                Integer allergenId = allergenInfo.getAllergenId();


                Allergen allergen = allergenService.getAllergenBy(allergenId);

                RecipeAllergen recipeAllergen = new RecipeAllergen();
                recipeAllergen.setRecipe(recipe);
                recipeAllergen.setAllergen(allergen);

                recipeAllergenService.saveRecipeAllergen(recipeAllergen);
            }


        }



    }
}
