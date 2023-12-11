package ee.valiit.yummy.domain.recipe;

import ee.valiit.yummy.business.recipe.course.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findRecipesByCourseId(Integer id);



}