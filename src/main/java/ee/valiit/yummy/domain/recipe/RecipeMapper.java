package ee.valiit.yummy.domain.recipe;

import ee.valiit.yummy.business.Status;
import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.business.recipe.dto.RecipeDetailedDto;
import org.mapstruct.*;

import java.util.List;
import ee.valiit.yummy.util.ImageConverter;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface RecipeMapper {

    @Mapping(source = "id", target = "recipeId")
    @Mapping(source = "user.id", target = "authorUserId")
    @Mapping(source = "user.username", target = "authorUsername")
    @Mapping(source = "image.data", target = "imageData", qualifiedByName = "byteArrayToString")
    @Mapping(source = "name", target = "recipeName")
    @Mapping(source = "timeMinute", target = "timeMinute")
    RecipeBasicDto toRecipeBasicDto(Recipe recipe);


    @Mapping(source = "name", target = "recipeName")
    @Mapping(source = "user.id", target = "authorUserId")
    @Mapping(source = "user.username", target = "authorUsername")
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "timeMinute", target = "timeMinute")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "image.data", target = "imageData", qualifiedByName = "byteArrayToString")
    RecipeDetailedDto toRecipeDetailedDto(Recipe recipe);

    @Mapping(source = "recipeName", target = "name")
    @Mapping(source = "timeMinute", target = "timeMinute")
    @Mapping(source = "description", target = "description")
    @Mapping(expression = "java(Status.ACTIVE)", target = "status")
    Recipe toRecipe (RecipeDetailedDto recipeBasicDto);


    List<RecipeBasicDto> toRecipeBasicDtos(List<Recipe> recipes);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] bytes) {
        return ImageConverter.byteArrayToString(bytes);
    }

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String string){
        return ImageConverter.stringToByteArray(string);
    }
}