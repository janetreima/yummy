package ee.valiit.yummy.domain.recipe;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Recipe getRecipeById(Integer recipeId) {
        return recipeRepository.getReferenceById(recipeId);
    }

}
