package ee.valiit.yummy.domain.recipe;

import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
import org.mapstruct.*;

import java.util.List;
import ee.valiit.yummy.util.ImageConverter;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipeMapper {

    @Mapping(source = "id", target = "recipeId")
    @Mapping(source = "user.id", target = "authorUserId")
    @Mapping(source = "user.username", target = "authorUsername")
    @Mapping(source = "image.data", target = "imageData", qualifiedByName = "byteArrayToString")
    @Mapping(source = "name", target = "recipeName")
    @Mapping(source = "timeMinute", target = "timeMinute")
    RecipeBasicDto toRecipeBasicDto(Recipe recipe);



    List<RecipeBasicDto> toRecipeBasicDto(List<Recipe> recipes);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] bytes) {
        return ImageConverter.byteArrayToString(bytes);
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "recipeName", target = "name")
    @Mapping(source = "courseId", target = "course.id")
    @Mapping(source = "timeMinute", target = "timeMinute")
    @Mapping(source = "description", target = "description")
//    @Mapping(source = "imageData", target = "image.data", qualifiedByName = "stringToByteArray")
    Recipe partialUpdate(@MappingTarget Recipe recipe, RecipeDetailedDto recipeDetailedDto);

}
