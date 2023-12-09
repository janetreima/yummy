package ee.valiit.yummy.domain.recipe.allergen;

import ee.valiit.yummy.business.allergen.dto.AllergenDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AllergenMapper {

    Allergen toEntity(AllergenDto allergenDto);

    @Mapping(source = "id", target = "allergenId")
    @Mapping(source = "name", target = "allergenName")
    AllergenDto toDto(Allergen allergen);

    List<AllergenDto> toAllergenDtos(List<Allergen> allergens);
}