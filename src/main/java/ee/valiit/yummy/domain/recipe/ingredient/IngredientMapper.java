package ee.valiit.yummy.domain.recipe.ingredient;

import ee.valiit.yummy.business.recipeingredient.RecipeIngredientRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {

    @Mapping(target = "name", source = "ingredientName")
    Ingredient toIngredient(RecipeIngredientRequest recipeIngredientRequest);

}