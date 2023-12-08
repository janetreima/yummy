package ee.valiit.yummy.domain.recipe.recipeingredient;

import ee.valiit.yummy.business.recipeingredient.RecipeIngredientDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipeIngredientMapper {

    @Mapping(source = "recipe.id", target = "recipeId")
    @Mapping(source = "ingredient.id", target = "ingredientId")
    @Mapping(source = "ingredient.name", target = "ingredientName")
    @Mapping(source = "measureUnit.id", target = "measureUnitId")
    @Mapping(source = "measureUnit.name", target = "measureUnitName")
    @Mapping(source = "quantity", target = "quantity")
    RecipeIngredientDto toRecipeIngredientDto(RecipeIngredient recipeIngredient);

    List<RecipeIngredientDto> toRecipeIngredientDtos(List<RecipeIngredient> recipeIngredients);

}