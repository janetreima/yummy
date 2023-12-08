package ee.valiit.yummy.domain.recipe.allergen;

import ee.valiit.yummy.business.allergen.dto.AllergenDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AllergenMapper {
    Allergen toEntity(AllergenDto allergenDto);

    AllergenDto toDto(Allergen allergen);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Allergen partialUpdate(AllergenDto allergenDto, @MappingTarget Allergen allergen);
}