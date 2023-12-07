package ee.valiit.yummy.business.allergen;

import ee.valiit.yummy.domain.recipe.allergen.Allergen;
import ee.valiit.yummy.domain.recipe.allergen.AllergenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergensService {

    @Resource
    private AllergenService allergenService;

    public List<Allergen> getAllAllergens() {
        return allergenService.getAllAllergens();
    }
}
