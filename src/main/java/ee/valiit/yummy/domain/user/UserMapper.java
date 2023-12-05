package ee.valiit.yummy.domain.user;

import ee.valiit.yummy.business.login.dto.LoginDto;
import ee.valiit.yummy.business.signup.dto.UserInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginDto toLoginDto(User user);

    User userFromUserDto(UserInfoDto userInfoDto);

}