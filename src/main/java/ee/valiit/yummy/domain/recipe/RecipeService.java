package ee.valiit.yummy.domain.recipe;

import ee.valiit.yummy.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Resource
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipe(Integer recipeId) {
        return recipeRepository.getReferenceById(recipeId);
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public List<Recipe> getUserRecipes(Integer userId) {
        return recipeRepository.findRecipesByUserId(userId);
    }

    public List<Recipe> getRecipesBy(List<Integer> courseIds) {
        return recipeRepository.findRecipesBy(courseIds);
    }

    public Recipe getRecipeById(Integer recipeId) {
        return recipeRepository.getReferenceById(recipeId);
    }

    public List<Recipe> getAllActiveRecipes() {
        return recipeRepository.findAllActiveRecipes(Status.ACTIVE);
    }
}
