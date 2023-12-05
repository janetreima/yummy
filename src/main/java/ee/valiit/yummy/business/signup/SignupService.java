package ee.valiit.yummy.business.signup;

import ee.valiit.yummy.business.signup.dto.UserInfoDto;
import ee.valiit.yummy.domain.profile.Profile;
import ee.valiit.yummy.domain.profile.ProfileMapper;
import ee.valiit.yummy.domain.profile.ProfileService;
import ee.valiit.yummy.domain.role.Role;
import ee.valiit.yummy.domain.user.User;
import ee.valiit.yummy.domain.user.UserMapper;
import ee.valiit.yummy.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Resource
    private ProfileMapper profileMapper;
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProfileService profileService;


    public void signUp(UserInfoDto userInfoDto) {

        System.out.println("we are in signUp service ");


        User user = userMapper.userFromUserDto(userInfoDto);
        System.out.println("Created new user " + user);
        user.setRole(new Role(2, "user"));
        userService.saveUser(user);
        System.out.println("saved user " + user);

        Profile profile = profileMapper.profileFromUserDto(userInfoDto);
        System.out.println("profile: " + profile);
        profile.setUser(user);
        System.out.println("profile: " + profile);

        profileService.saveProfile(profile);
        System.out.println("saved profile " + profile);
    }

}

