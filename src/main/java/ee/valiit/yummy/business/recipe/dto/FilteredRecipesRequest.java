package ee.valiit.yummy.business.recipe.dto;

import ee.valiit.yummy.business.allergen.dto.AllergenInfo;
import lombok.Data;

import java.util.List;

@Data
public class FilteredRecipesRequest {

    private List<AllergenInfo> allergenInfos;
    private List<CourseInfo> courseInfos;

}
