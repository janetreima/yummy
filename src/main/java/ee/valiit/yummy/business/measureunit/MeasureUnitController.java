package ee.valiit.yummy.business.measureunit;

import ee.valiit.yummy.domain.recipe.measureunit.MeasureUnit;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeasureUnitController {

    @Resource
    private MeasureUnitsService measureUnitsService;

    @GetMapping("/recipe/measureunits")
    @Operation(summary = "tagastab kõik andmebaasis olevad mõõtühikud")
    public List<MeasureUnit> getAllMeasureUnits() {
        return measureUnitsService.getAllMeasureUnits();
    }
}
