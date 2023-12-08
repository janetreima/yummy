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
    private ImageService imageService;

    @Resource
    private RecipeMapper recipeMapper;

    @Resource
    private CourseService courseService;

    public List<RecipeBasicDto> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipeMapper.toRecipeBasicDto(recipes);
    }


    public void addRecipe(Integer userId, RecipeDetailedDto recipeBasicDto) {

    }


    // TODO vaja teha eeltoo

    // TODO vaja luua Image objekt ja see andmebaasi salvestada
    //  EntityService ->
    //  EntityRepository ->
    //  save()
    //  nyyd on olemas image object koos id v''rtusega


    // TODO leia ulese userId abil User object.
    //  EntityService ->
    //  EntityRepository ->
    //  getReferenceById (selline meetod on JPA repositoris on olemas. ei pea uut tegima)
    //  = Entity object


    // TODO leia ulese courseId abil Course object.
    //  EntityService ->
    //  EntityRepository ->
    //  getReferenceById (selline metod on JPA repositoris on olemas. ei pea uut tegima)
    //  = Entity object


    // TODO on vaja teha uus sissekanne tabelisse recipe
    // TODO on vaja luua uus recipe object
    // TODO koige m6istlikum oleks kasutada RecipeMapperit.
    //  sealt oleks vaja meetodit toRecipe(), mis v6ttab sisse RecipeDetailedDto objecti ja tagastab Recipe objecti.
    //  Seda meetodit veel ei ole see tuleb luua.
    //  selliselt saad recipe objecti
    //  Ara said mappida name, time?minute ja description. User, Image ja Course objekti ei saanud ega tohtinud ara mappida.
    //  See user, image ja course object on eelnevalt olemas. Nuud peab need  user, image ja course objectid lihtsalt panema recipe objecti kulge.
    //  Nuud on recipe object valmis. Peab lihtsalt selle ka andmebaasi ara salvestada.
    //  EntityService ->
    //  EntityRepository ->
    //  save() - selline metod on JPA repositoris on olemas. ei pea uut tegima.
    //  Nuud on recipe object valmis millel on kuljes ka Id (see rida on andmebaasis olemas)


    // TODO on vaja teha uued sissekanded tabelisse recipe_allergen
    // TODO on vaja luua uus tyhi list RecipeAllergen objectidest (new ArrayList) ja panna muutuja nimeks recipeAllergens
    // TODO on vaja v6tta RecipeDetailedDto objecti seest List<AllergenDto> allergenInfos massiiv
    //  nuud oleks vaja for loopida seda allergenInfos massiivi
    //  Igal tsuklil tuleb vaadata uhte allergenInfo objecti
    //  Kui allergenInfo objecti vali isAvailable on true siis tuleb leida valja allergenId abil ulesse allergen object (Entity Allergen)
    //  EntityService ->
    //  EntityRepository ->
    //  getReferenceById (selline metod on JPA repositoris on olemas. ei pea uut tegima)
    //  = Entity object
    //  Nuud on sul olemas allergen object (Entity)
    //  Nuud on vaja luua uus recipeAllergen object (new RecipeAllergen()).
    //  Nuud peab selle recipeAllergen objecti kulge panema recipe ja allergen objecti. (recipe object on sul varasemalt olemas)
    //  Nuud on recipeAllergen object valmis. Peab lihtsalt selle lisama recipeAllergens listi
    //  parast for tsuklit on sul olemas taidetud recipeAllergens list
    //  Peab lihtsalt selle ka andmebaasi ara salvestada.
    //  EntityService ->
    //  EntityRepository ->
    //  saveAll() - selline metod on JPA repositoris on olemas. ei pea uut tegima. See meetod v6tab sisse Entityd listi
    //  Finito


    public void editRecipe(Integer recipeId, RecipeDetailedDto recipeDetailedDto) {

        Recipe recipe = recipeService.getRecipeById(recipeId);
        recipeMapper.partialUpdate(recipe, recipeDetailedDto);
        handleCourseUpdate(recipe, recipeDetailedDto);
        handleImage(recipe, recipeDetailedDto);
        handleNewImage(recipe, recipeDetailedDto);
    }

    private void handleCourseUpdate(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        if (isCourseUpdateRequired(recipeDetailedDto, recipe)) {
            Course course = courseService.getCourseById(recipeDetailedDto.getCourseId());
            recipe.setCourse(course);
        }
    }

    private static boolean isCourseUpdateRequired(RecipeDetailedDto recipeDetailedDto, Recipe recipe) {
        return !haveSameCourseIds(recipe, recipeDetailedDto);
    }

    private static boolean haveSameCourseIds(Recipe recipe, RecipeDetailedDto recipeDetailedDto) {
        return recipe.getCourse().getId().equals(recipeDetailedDto.getCourseId());
    }

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

}
