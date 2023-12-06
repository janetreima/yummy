package ee.valiit.yummy.business.recipe;

import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
import ee.valiit.yummy.domain.image.ImageService;
import ee.valiit.yummy.domain.recipe.Recipe;
import ee.valiit.yummy.domain.recipe.RecipeMapper;
import ee.valiit.yummy.domain.recipe.RecipeService;
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
    private RecipeMapper recipeMapper;

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
        // nyyd on olemas image object koos id v''rtusega


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


}
