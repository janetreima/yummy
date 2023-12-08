package ee.valiit.yummy.domain.recipe.recipeallergen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeAllergenRepository extends JpaRepository<RecipeAllergen, Integer> {
    @Query("select r from RecipeAllergen r where r.recipe.id = ?1")
    List<RecipeAllergen> findRecipeAllergensByRecipeId(Integer id);

}