package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedResponseDto;
import ee.valiit.yummy.business.recipeallergen.RecipeAllergenDto;
import ee.valiit.yummy.business.recipeingredient.RecipeIngredientDto;
import ee.valiit.yummy.domain.image.Image;
import ee.valiit.yummy.domain.image.ImageService;
import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.RecipeMapper;
import ee.valiit.yummy.domain.recipe.RecipeService;
import ee.valiit.yummy.domain.recipe.allergen.AllergenService;
import ee.valiit.yummy.domain.recipe.course.Course;
import ee.valiit.yummy.domain.recipe.course.CourseService;
import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergen;
import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergenMapper;
import ee.valiit.yummy.domain.recipe.recipeallergen.RecipeAllergenService;
import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredient;
import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredientMapper;
import ee.valiit.yummy.domain.recipe.recipeingredient.RecipeIngredientService;
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
    private AllergenService allergenService;

    @Resource
    private ImageService imageService;

    @Resource
    private CourseService courseService;

    @Resource
    private UserService userService;

    @Resource
    private RecipeAllergenService recipeAllergenService;

    @Resource
    private RecipeIngredientService recipeIngredientService;

    @Resource
    private RecipeMapper recipeMapper;

    @Resource
    private RecipeAllergenMapper recipeAllergenMapper;

    @Resource
    private RecipeIngredientMapper recipeIngredientMapper;

    @Resource
    private ImageConverter imageConverter;

    public List<RecipeBasicDto> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipeMapper.toRecipeBasicDto(recipes);
    }

    public RecipeDetailedResponseDto getRecipe(Integer recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        RecipeDetailedResponseDto recipeDetailedResponseDto = recipeMapper.toRecipeDetailedResponseDto(recipe);
        getAndSetRecipeAllergens(recipeId, recipeDetailedResponseDto);
        getAndSetRecipeIngredients(recipeId, recipeDetailedResponseDto);
        return recipeDetailedResponseDto;
    }

    private void getAndSetRecipeIngredients(Integer recipeId, RecipeDetailedResponseDto recipeDetailedResponseDto) {
        List<RecipeIngredient> recipeIngredients = recipeIngredientService.getRecipeIngredientsBy(recipeId);
        List<RecipeIngredientDto> recipeIngredientDtos = recipeIngredientMapper.toRecipeIngredientDtos(recipeIngredients);
        recipeDetailedResponseDto.setIngredientInfos(recipeIngredientDtos);
    }

    private void getAndSetRecipeAllergens(Integer recipeId, RecipeDetailedResponseDto recipeDetailedResponseDto) {
        List<RecipeAllergen> recipeAllergens = recipeAllergenService.findRecipeAllergensBy(recipeId);
        List<RecipeAllergenDto> recipeAllergenDtos = recipeAllergenMapper.toRecipeAllergenDtos(recipeAllergens);
        recipeDetailedResponseDto.setAllergenInfos(recipeAllergenDtos);
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


