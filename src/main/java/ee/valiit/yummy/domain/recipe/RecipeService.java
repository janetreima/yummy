package ee.valiit.yummy.domain.recipe;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Recipe> getFilteredRecipes(Integer courseId) {
        return recipeRepository.findRecipesByCourseId(courseId);
    }

    public List<Recipe> getRecipesBy(List<Integer> courseIds) {
        return recipeRepository.findRecipesBy(courseIds);
    }

    public Optional<Recipe> getRecipeById(Integer recipeId) {
        return recipeRepository.findById(recipeId);
    }
}
