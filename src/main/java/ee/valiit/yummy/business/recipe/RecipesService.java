package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
import ee.valiit.yummy.domain.image.Image;
import ee.valiit.yummy.domain.image.ImageService;
import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.RecipeMapper;
import ee.valiit.yummy.domain.recipe.RecipeService;
import ee.valiit.yummy.domain.recipe.course.Course;
import ee.valiit.yummy.domain.recipe.course.CourseService;
import ee.valiit.yummy.domain.user.User;
import ee.valiit.yummy.domain.user.UserService;
import ee.valiit.yummy.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesService {

    @Resource
    private RecipeService recipeService;
    @Resource
    private ImageService imageService;

    @Resource
    private UserService userService;
    @Resource
    private CourseService courseService;

    @Resource
    private RecipeMapper recipeMapper;


    public List<RecipeBasicDto> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipeMapper.toRecipeBasicDto(recipes);
    }


    public void addRecipe(Integer userId, RecipeDetailedDto recipeDetailedDto) {
        Recipe recipe = recipeMapper.toRecipe(recipeDetailedDto);
        Image image = ImageConverter.stringToImage(recipeDetailedDto.getImageData());
        imageService.saveImage(image);
        recipe.setImage(image);
        User user = userService.getUserById(userId);
        recipe.setUser(user);
        Course course = courseService.getCourseBy(recipeDetailedDto.getCourseId());
        recipe.setCourse(course);
        recipeService.saveRecipe(recipe);

    }


}
