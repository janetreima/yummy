package ee.valiit.yummy.domain.recipe.allergen;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergenService {

    @Resource
    private AllergenRepository allergenRepository;

    public Allergen getAllergenBy(Integer allergenId) {
        return allergenRepository.getReferenceById(allergenId);
    }

    public List<Allergen> getAllAllergens() {
        return allergenRepository.findAll();

    }


}
