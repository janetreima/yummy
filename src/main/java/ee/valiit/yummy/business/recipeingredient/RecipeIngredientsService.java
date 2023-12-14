package ee.valiit.yummy.business.recipeingredient;


import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.RecipeService;
import ee.valiit.yummy.domain.recipe.ingredient.Ingredient;
import ee.valiit.yummy.domain.recipe.ingredient.IngredientMapper;
import ee.valiit.yummy.domain.recipe.ingredient.IngredientRepository;
import ee.valiit.yummy.domain.recipe.ingredient.IngredientService;
import ee.valiit.yummy.domain.recipe.measureunit.MeasureUnit;
import ee.valiit.yummy.domain.recipe.measureunit.MeasureUnitRepository;
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
    private RecipeService recipeService;

    @Resource
    private IngredientService ingredientService;

    @Resource
    private IngredientMapper ingredientMapper;

    @Resource
    private RecipeIngredientMapper recipeIngredientMapper;
    private final IngredientRepository ingredientRepository;
    private final MeasureUnitRepository measureUnitRepository;

    public RecipeIngredientsService(IngredientRepository ingredientRepository,
                                    MeasureUnitRepository measureUnitRepository) {
        this.ingredientRepository = ingredientRepository;
        this.measureUnitRepository = measureUnitRepository;
    }

    public List<RecipeIngredientDto> getRecipeIngredientsBy(Integer recipeId) {
        List<RecipeIngredient> recipeIngredients = recipeIngredientService.getRecipeIngredientsBy(recipeId);
        return recipeIngredientMapper.toRecipeIngredientDtos(recipeIngredients);
    }

    public void addRecipeIngredient(Integer recipeId, RecipeIngredientRequest recipeIngredientRequest) {

        RecipeIngredient recipeIngredient = recipeIngredientMapper.toRecipeIngredient(recipeIngredientRequest);

        Recipe recipe = recipeService.getRecipeBy(recipeId);
        recipeIngredient.setRecipe(recipe);

        Ingredient ingredient = ingredientMapper.toIngredient(recipeIngredientRequest);
        ingredientRepository.save(ingredient);
        recipeIngredient.setIngredient(ingredient);

        MeasureUnit measureUnit = measureUnitRepository.getReferenceById(recipeIngredientRequest.getMeasureUnitId());
        recipeIngredient.setMeasureUnit(measureUnit);

        recipeIngredientService.saveRecipeIngredient(recipeIngredient);
    }

    public void deleteRecipeIngredient(Integer ingredientId) {
        recipeIngredientService.deleteRecipeIngredient(ingredientId);
    }
}

