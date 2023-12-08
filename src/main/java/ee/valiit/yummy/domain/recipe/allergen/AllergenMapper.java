package ee.valiit.yummy.domain.recipe.allergen;

import ee.valiit.yummy.business.allergen.dto.AllergenDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AllergenMapper {

    Allergen toEntity(AllergenDto allergenDto);

    @Mapping(source = "id", target = "allergenId")
    @Mapping(source = "name", target = "allergenName")
    AllergenDto toDto(Allergen allergen);
}