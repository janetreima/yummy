package ee.valiit.yummy.business.allergen;

import ee.valiit.yummy.domain.recipe.allergen.Allergen;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllergensController {

    @Resource
    private AllergensService allergensService;

    @GetMapping("/recipe/allergens")
    @Operation(summary = "Tagastab kõik allergeenide valikud")
    public List<Allergen> getAllAllergens() {
        return allergensService.getAllAllergens();
    }
}
