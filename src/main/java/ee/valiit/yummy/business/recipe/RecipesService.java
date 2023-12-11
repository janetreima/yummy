package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.Status;
import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
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

import java.util.Arrays;
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
        return recipeMapper.toRecipeBasicDtos(recipes);
    }

    public RecipeDetailedDto getRecipeBy(Integer recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        RecipeDetailedDto recipeDetailedDto = recipeMapper.toRecipeDetailedDto(recipe);
        getAndSetRecipeAllergens(recipeId, recipeDetailedDto);
        getAndSetRecipeIngredients(recipeId, recipeDetailedDto);
        return recipeDetailedDto;
    }

    private void getAndSetRecipeIngredients(Integer recipeId, RecipeDetailedDto recipeDetailedDto) {
        List<RecipeIngredient> recipeIngredients = recipeIngredientService.getRecipeIngredientsBy(recipeId);
        List<RecipeIngredientDto> recipeIngredientDtos = recipeIngredientMapper.toRecipeIngredientDtos(recipeIngredients);
        recipeDetailedDto.setIngredientInfos(recipeIngredientDtos);
    }

    private void getAndSetRecipeAllergens(Integer recipeId, RecipeDetailedDto recipeDetailedDto) {
        List<RecipeAllergen> recipeAllergens = recipeAllergenService.findRecipeAllergensBy(recipeId);
        List<RecipeAllergenDto> recipeAllergenDtos = recipeAllergenMapper.toRecipeAllergenDtos(recipeAllergens);
        recipeDetailedDto.setAllergenInfos(recipeAllergenDtos);
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

    public List<RecipeBasicDto> getFilteredRecipes(Integer courseId) {
        List<Recipe> recipes = recipeService.getFilteredRecipes(courseId);
        return recipeMapper.toRecipeBasicDtos(recipes);

    }

    public void editRecipe(Integer recipeId, RecipeDetailedDto recipeDetailedDto) {

        Recipe recipe = recipeService.getRecipeById(recipeId).get();
        recipeMapper.partialUpdate(recipe, recipeDetailedDto);
        handleCourseUpdate(recipe, recipeDetailedDto);
        handleImage(recipe, recipeDetailedDto);
        handleNewImage(recipe, recipeDetailedDto);
    }

    private void handleCourseUpdate(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        if (isCourseUpdateRequired(recipeDetailedDto, recipe)) {
            Course course = courseService.getCourseBy(recipeDetailedDto.getCourseId());
            recipe.setCourse(course);
        }
    }

    private static boolean isCourseUpdateRequired(RecipeDetailedDto recipeDetailedDto, Recipe recipe) {
        return !haveSameCourseIds(recipe, recipeDetailedDto);  //   kui id erinevad siis on flase
    }

    private static boolean haveSameCourseIds(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        return recipe.getCourse().getId().equals(recipeDetailedDto.getCourseId()); // kui true siis Ids on sama
    }                  // id = 1                               id = 1

    private void handleImage(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        handleImageUpdate(recipe, recipeDetailedDto);
        handleNewImage(recipe, recipeDetailedDto);

    }

    private void handleImageUpdate(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        if (isImageUpdateRequired(recipe, recipeDetailedDto)) {
            byte[] imageAsByte = ImageConverter.stringToByteArray(recipeDetailedDto.getImageData());
            Image image = recipe.getImage();
            image.setData(imageAsByte);
            imageService.saveImage(image);
        }
    }

    private static boolean isImageUpdateRequired(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        return recipe.getImage() != null && !haveSameImageData(recipe, recipeDetailedDto);
    }

    private static boolean haveSameImageData(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        return Arrays.equals(recipe.getImage().getData(), ImageConverter.stringToByteArray(recipeDetailedDto.getImageData()));
    }

    private void handleNewImage(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        if (isNewImageRequired(recipe, recipeDetailedDto)) {
            Image image = ImageConverter.stringToImage(recipeDetailedDto.getImageData());
            imageService.saveImage(image);
        }
    }

    private static boolean isNewImageRequired(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        return !imageDataExistsMethodOne(recipe.getImage()) && imageDataExistsMethodTwo(recipeDetailedDto.getImageData());
    }


    private static boolean imageDataExistsMethodOne(Image image) {
        if (image == null) {
            return false;
        }
        return image.getData() != null && image.getData().length > 0;
    }

    private static boolean imageDataExistsMethodTwo(String imageData) {
        return imageData != null && !imageData.isEmpty();
    }

    public void deleteRecipe(Integer recipeId) {

        Recipe recipe = recipeService.getRecipeById(recipeId).get();
        recipe.setStatus(Status.DELETED);
//        recipe.setStatus(Status.ACTIVE);       Kui on vaja tagastada ACTIVE status
        recipeService.saveRecipe(recipe);
    }

}

