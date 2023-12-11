package ee.valiit.yummy.domain.profile;


import ee.valiit.yummy.business.signup.dto.UserInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface ProfileMapper {
    Profile profileFromUserDto (UserInfoDto userInfoDto);

}
