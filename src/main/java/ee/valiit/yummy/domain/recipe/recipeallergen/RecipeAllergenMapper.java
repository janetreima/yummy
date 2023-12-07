package ee.valiit.yummy.domain.recipe.recipeallergen;

import ee.valiit.yummy.business.recipeallergen.RecipeAllergenDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipeAllergenMapper {

    @Mapping(source = "recipe.id", target = "recipeId")
    @Mapping(source = "allergen.id", target = "allergenId")
    @Mapping(source = "allergen.name", target = "allergenName")
    RecipeAllergenDto toDto(RecipeAllergen recipeAllergen);

    List<RecipeAllergenDto> toRecipeAllergenDtos(List<RecipeAllergen> recipeAllergens);

}