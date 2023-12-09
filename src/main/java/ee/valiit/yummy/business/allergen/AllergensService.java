package ee.valiit.yummy.business.allergen;

import ee.valiit.yummy.business.allergen.dto.AllergenDto;
import ee.valiit.yummy.domain.recipe.allergen.Allergen;
import ee.valiit.yummy.domain.recipe.allergen.AllergenMapper;
import ee.valiit.yummy.domain.recipe.allergen.AllergenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergensService {

    @Resource
    private AllergenService allergenService;

    @Resource
    private AllergenMapper allergenMapper;

    public List<AllergenDto> getAllAllergens() {
        List <Allergen> allergens = allergenService.getAllAllergens();
        return allergenMapper.toAllergenDtos(allergens);
    }
}
