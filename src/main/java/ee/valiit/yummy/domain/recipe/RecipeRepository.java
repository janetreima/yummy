package ee.valiit.yummy.domain.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findRecipesByUserId(Integer id);


    @Query("select r from Recipe r where r.course.id in :courseIds order by r.name")
    List<Recipe> findRecipesBy(List<Integer> courseIds);


}