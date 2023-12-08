package ee.valiit.yummy.domain.recipe.recipeingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {
    @Query("select r from RecipeIngredient r where r.recipe.id = ?1")
    List<RecipeIngredient> getRecipeIngredientsBy(Integer id);


}