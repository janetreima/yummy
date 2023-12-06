package ee.valiit.yummy.infrastructure.validation;

import ee.valiit.yummy.domain.user.User;
import ee.valiit.yummy.infrastructure.exception.BusinessException;

import java.util.Optional;

import static ee.valiit.yummy.infrastructure.validation.Error.INCORRECT_CREDENTIALS;


public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }


}
