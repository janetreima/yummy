package ee.valiit.yummy.domain.user;

import ee.valiit.yummy.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findUserBy(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password);
        return ValidationService.getValidUser(optionalUser);
    }
}
