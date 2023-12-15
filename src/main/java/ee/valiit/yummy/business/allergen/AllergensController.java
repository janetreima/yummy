package ee.valiit.yummy.business.allergen;

import ee.valiit.yummy.business.allergen.dto.AllergenInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllergensController {

    @Resource
    private AllergensService allergensService;

    @GetMapping("/allergens")
    @Operation(summary = "Tagastab kõik allergeenide valikud")
    public List<AllergenInfo> getAllAllergens() {
        return allergensService.getAllAllergens();
    }


}
