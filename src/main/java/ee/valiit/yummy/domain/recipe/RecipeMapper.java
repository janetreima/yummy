package ee.valiit.yummy.domain.recipe;

import ee.valiit.yummy.business.recipe.RecipeDto;
import org.mapstruct.*;

import java.util.List;
import ee.valiit.yummy.util.ImageConverter;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipeMapper {

    @Mapping(source = "id", target = "recipeId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "course.name", target = "courseName")
    @Mapping(source = "image.id", target = "imageId")
    @Mapping(source = "image.data", target = "imageData", qualifiedByName = "byteArrayToString")
    @Mapping(source = "name", target = "recipeName")
    @Mapping(source = "timeMinute", target = "timeMinute")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "status", target = "status")
    RecipeDto toRecipeDto(Recipe recipe);

    Recipe toRecipe (RecipeDto recipeDto);


    List<RecipeDto> toRecipeDtos(List<Recipe> recipes);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] bytes) {
        return ImageConverter.byteArrayToString(bytes);
    }
}