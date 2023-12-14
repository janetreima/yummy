package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.allergen.dto.AllergenInfo;
import ee.valiit.yummy.business.recipe.dto.*;
import ee.valiit.yummy.business.Status;
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

import java.util.ArrayList;
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

    public List<RecipeBasicDto> getAllActiveRecipes() {
        List<Recipe> recipes = recipeService.getAllActiveRecipes();
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

    public RecipeIdInfo addRecipe(Integer userId, RecipeRequest recipeRequest) {
        Recipe recipe = recipeMapper.toRecipe(recipeRequest);
        Image image = ImageConverter.stringToImage(recipeRequest.getImageData());
        imageService.saveImage(image);
        recipe.setImage(image);
        User user = userService.getUserById(userId);
        recipe.setUser(user);
        Course course = courseService.getCourseBy(recipeRequest.getCourseId());
        recipe.setCourse(course);
        recipeService.saveRecipe(recipe);
        return new RecipeIdInfo(recipe.getId());
    }


    public void editRecipe(Integer recipeId, RecipeRequest recipeRequest) {

        Recipe recipe = recipeService.getRecipeById(recipeId);
        recipeMapper.partialUpdate(recipe, recipeRequest);
        handleCourseUpdate(recipe, recipeRequest.getCourseId());
        handleImage(recipe, recipeRequest);
        recipeService.saveRecipe(recipe);
    }

    private void handleCourseUpdate(Recipe recipe, Integer newCourseId) {
        Integer recipeCourseId = recipe.getCourse().getId();
        if (isCourseUpdateRequired(newCourseId, recipeCourseId)) {
            Course course = courseService.getCourseBy(newCourseId);
            recipe.setCourse(course);
        }
    }

    private static boolean isCourseUpdateRequired(Integer newCourseId, Integer recipeCourseId) {
        return !haveSameCourseIds(recipeCourseId, newCourseId);  //   kui id erinevad siis on flase
    }

    private static boolean haveSameCourseIds(Integer recipeCourseId, Integer newCourseId) {
        return recipeCourseId.equals(newCourseId); // kui true siis Ids on sama
    }                  // id = 1                               id = 1

    private void handleImage(Recipe recipe, RecipeRequest recipeRequest) {
        handleImageUpdate(recipe, recipeRequest);
        handleNewImage(recipe, recipeRequest);

    }

    private void handleImageUpdate(Recipe recipe, RecipeRequest recipeRequest) {
        if (isImageUpdateRequired(recipe, recipeRequest)) {
            byte[] imageAsByte = ImageConverter.stringToByteArray(recipeRequest.getImageData());
            Image image = recipe.getImage();
            image.setData(imageAsByte);
            imageService.saveImage(image);
        }
    }

    private static boolean isImageUpdateRequired(Recipe recipe, RecipeRequest recipeRequest) {
        return recipe.getImage() != null && !haveSameImageData(recipe, recipeRequest);
    }

    private static boolean haveSameImageData(Recipe recipe, RecipeRequest recipeRequest) {
        return Arrays.equals(recipe.getImage().getData(), ImageConverter.stringToByteArray(recipeRequest.getImageData()));
    }

    private void handleNewImage(Recipe recipe, RecipeRequest recipeRequest) {
        if (isNewImageRequired(recipe, recipeRequest)) {
            Image image = ImageConverter.stringToImage(recipeRequest.getImageData());
            imageService.saveImage(image);
            recipe.setImage(image);
        }
    }

    private static boolean isNewImageRequired(Recipe recipe, RecipeRequest recipeRequest) {
        return recipe.getImage() == null && !recipeRequest.getImageData().isEmpty();
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
        Recipe recipe = recipeService.getRecipeById(recipeId);
        recipe.setStatus(Status.DELETED);
        recipeService.saveRecipe(recipe);
    }

    public List<RecipeBasicDto> getUserRecipes(Integer userId) {
        List<Recipe> recipes = recipeService.getUserRecipes(userId);
        return recipeMapper.toRecipeBasicDtos(recipes);

    }


    public List<RecipeBasicDto> getFilteredRecipes(FilteredRecipesRequest filteredRecipesRequest) {
        List<Recipe> activeRecipes = recipeService.getAllActiveRecipes();
        List<Recipe> courseFilteredRecipes = handleCourseFilteredRecipes(filteredRecipesRequest);
        return handleAllergenFilteredRecipes(filteredRecipesRequest, courseFilteredRecipes);
    }

    private List<RecipeBasicDto> handleAllergenFilteredRecipes(FilteredRecipesRequest filteredRecipesRequest, List<Recipe> courseFilteredRecipes) {
        List<Integer> allergenIds = getAllergenIds(filteredRecipesRequest.getAllergenInfos());
        if (allergenIds.isEmpty()) {
            return recipeMapper.toRecipeBasicDtos(courseFilteredRecipes);
        } else {
            List<Recipe> allergenFilteredRecipes = getAllergenFilteredRecipes(courseFilteredRecipes, allergenIds);
            return recipeMapper.toRecipeBasicDtos(allergenFilteredRecipes);
        }
    }

    private List<Recipe> handleCourseFilteredRecipes(FilteredRecipesRequest filteredRecipesRequest) {
        List<Integer> courseIds = getCourseIds(filteredRecipesRequest.getCourseInfos());

        List<Recipe> courseFilteredRecipes;
        if (courseIds.isEmpty()) {
            courseFilteredRecipes = recipeService.getAllRecipes();
        } else {
            courseFilteredRecipes = recipeService.getRecipesBy(courseIds);
        }
        return courseFilteredRecipes;
    }

//private List<Recipe> getActiveFilteredRecipes(List<Recipe> allergenFilteredRecipes, List<Recipe> activeRecipes) {
//        List<Recipe> filteredActiveRecipes = new ArrayList<>(activeRecipes);
//        filteredActiveRecipes.retainAll(allergenFilteredRecipes);
//        return filteredActiveRecipes;
//}

    private List<Recipe> getAllergenFilteredRecipes(List<Recipe> courseFilteredRecipes, List<Integer> allergenIds) {
        List<Recipe> allergenFilteredRecipes = new ArrayList<>();
        for (Recipe courseFilteredRecipe : courseFilteredRecipes) {
            if (recipeAllergenService.recipeExistsBy(courseFilteredRecipe.getId(), allergenIds)) {
                allergenFilteredRecipes.add(courseFilteredRecipe);
            }
        }
        return allergenFilteredRecipes;
    }

    private List<Integer> getAllergenIds(List<AllergenInfo> allergenInfos) {
        List<Integer> allergenIds = new ArrayList<>();
        for (AllergenInfo allergenInfo : allergenInfos) {
            if (allergenInfo.getIsAvailable()) {
                allergenIds.add(allergenInfo.getAllergenId());
            }
        }
        return allergenIds;
    }

    private static List<Integer> getCourseIds(List<CourseInfo> courseInfos) {
        List<Integer> courseIds = new ArrayList<>();
        for (CourseInfo courseInfo : courseInfos) {
            if (courseInfo.getIsAvailable()) {
                courseIds.add(courseInfo.getCourseId());
            }
        }
        return courseIds;
    }

}

