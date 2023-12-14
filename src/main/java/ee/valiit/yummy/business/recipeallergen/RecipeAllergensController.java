package ee.valiit.yummy.business.recipeallergen;

import ee.valiit.yummy.business.allergen.AllergensService;
import ee.valiit.yummy.business.allergen.dto.AllergenInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeAllergensController {

    @Resource
    private RecipeAllergensService recipeAllergensService;

    @PostMapping("/recipe/allergens")
    @Operation(summary = "Salvestab allergens to Recipe")
    public void addAllergensToRecipe (@RequestParam Integer recipeId ,@RequestBody List<AllergenInfo> allergenInfos) {
        recipeAllergensService.addAllergensToRecipe(recipeId, allergenInfos);

    }
}
