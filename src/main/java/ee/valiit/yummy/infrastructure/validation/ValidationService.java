package ee.valiit.yummy.infrastructure.validation;

import ee.valiit.yummy.business.recipe.dto.RecipeBasicDto;
import ee.valiit.yummy.domain.user.User;
import ee.valiit.yummy.infrastructure.exception.BusinessException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.yummy.infrastructure.validation.Error.INCORRECT_CREDENTIALS;
import static ee.valiit.yummy.infrastructure.validation.Error.NO_RECIPES_FOUND;


public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static List<RecipeBasicDto> getFilteredRecipes(List<RecipeBasicDto> filteredRecipes) {
        if (filteredRecipes.isEmpty()) {
            throw new BusinessException(NO_RECIPES_FOUND.getMessage(), NO_RECIPES_FOUND.getErrorCode());
        }
        return filteredRecipes;
    }




}
