package ee.valiit.yummy.business.signup;

import ee.valiit.yummy.business.signup.dto.UserInfoDto;
import ee.valiit.yummy.domain.profile.Profile;
import ee.valiit.yummy.domain.profile.ProfileMapper;
import ee.valiit.yummy.domain.profile.ProfileService;
import ee.valiit.yummy.domain.user.role.Role;
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

        User user = userMapper.userFromUserDto(userInfoDto);    //sozdal User user 1)
        user.setRole(new Role(2, "user"));   //  2) prinuditeljno zahardkodil Role=2
        userService.saveUser(user);                //  3) sohranjaju v tablicu user
        Profile profile = profileMapper.profileFromUserDto(userInfoDto);
        profile.setUser(user);
        profileService.saveProfile(profile);
    }

}

