package ee.valiit.yummy.domain.recipe.measureunit;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureUnitService {

    @Resource
    private MeasureUnitRepository measureUnitRepository;


    public List<MeasureUnit> getAllMeasureUnits() {
       return measureUnitRepository.findAll();
    }
}
