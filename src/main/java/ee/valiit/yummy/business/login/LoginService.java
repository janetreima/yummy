package ee.valiit.yummy.business.login;

import ee.valiit.yummy.business.login.dto.LoginDto;
import ee.valiit.yummy.domain.user.User;
import ee.valiit.yummy.domain.user.UserMapper;
import ee.valiit.yummy.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    public LoginDto login(String username, String password) {
        User user = userService.findUserBy(username, password);
        return userMapper.toLoginDto(user);
    }
}
