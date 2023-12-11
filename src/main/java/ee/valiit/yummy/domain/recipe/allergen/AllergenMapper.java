package ee.valiit.yummy.domain.recipe.allergen;

import ee.valiit.yummy.business.allergen.dto.AllergenInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AllergenMapper {

    Allergen toEntity(AllergenInfo allergenInfo);

    @Mapping(source = "id", target = "allergenId")
    @Mapping(source = "name", target = "allergenName")
    @Mapping(constant = "false", target = "isAvailable")
    AllergenInfo toDto(Allergen allergen);

    List<AllergenInfo> toAllergenDtos(List<Allergen> allergens);
}