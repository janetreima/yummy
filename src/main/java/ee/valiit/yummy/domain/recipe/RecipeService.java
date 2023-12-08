package ee.valiit.yummy.domain.recipe;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Resource
    private RecipeRepository recipeRepository;
    @Resource RecipeMapper recipeMapper;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }




}
