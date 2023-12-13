package ee.valiit.yummy.business.ingredient;

import ee.valiit.yummy.domain.recipe.ingredient.Ingredient;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientsController {

    @Resource
    private IngredientsService ingredientsService;

    @GetMapping("/recipe/allingredients")
    @Operation(summary = "tagastab kõik andmebaasis olevad koostisosad")
    public List<Ingredient> getAllIngredients() {
        return ingredientsService.getAllIngredients();
    }
}
