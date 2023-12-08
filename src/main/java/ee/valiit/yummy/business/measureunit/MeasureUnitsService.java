package ee.valiit.yummy.business.measureunit;

import ee.valiit.yummy.domain.recipe.measureunit.MeasureUnit;
import ee.valiit.yummy.domain.recipe.measureunit.MeasureUnitService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureUnitsService {

    @Resource
    private MeasureUnitService measureUnitService;

    public List<MeasureUnit> getAllMeasureUnits() {
        return measureUnitService.getAllMeasureUnits();
    }
}
