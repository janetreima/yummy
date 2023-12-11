package ee.valiit.yummy.domain.recipe;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Resource
    private RecipeRepository recipeRepository;

    @Resource
    private RecipeMapper recipeMapper;

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

    public Optional<Recipe> getRecipeById(Integer recipeId) {
        return recipeRepository.findById(recipeId);
    }
}
