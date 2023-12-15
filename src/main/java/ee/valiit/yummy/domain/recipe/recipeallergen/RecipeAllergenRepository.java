package ee.valiit.yummy.domain.recipe.recipeallergen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RecipeAllergenRepository extends JpaRepository<RecipeAllergen, Integer> {
    @Query("select r from RecipeAllergen r where r.recipe.id = ?1")
    List<RecipeAllergen> findRecipeAllergensByRecipeId(Integer id);

    @Query("select (count(r) > 0) from RecipeAllergen r where r.recipe.id = :recipeId and r.allergen.id in :allergenIds " +
            "group by r.recipe having count(distinct r.allergen.id) = :numberOfAllergens")
    Optional<Boolean> existsBy(Integer recipeId, List<Integer> allergenIds, Integer numberOfAllergens);


    @Transactional
    @Modifying
    @Query("delete from RecipeAllergen r where r.recipe.id = ?1")
    int deleteRecipeAllergensBy(Integer locationId);
}