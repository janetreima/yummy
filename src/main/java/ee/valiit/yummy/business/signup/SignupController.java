package ee.valiit.yummy.business.signup;


import ee.valiit.yummy.business.signup.dto.UserInfoDto;
import ee.valiit.yummy.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class SignupController {

    @Resource
    private SignupService signupService;

    @PostMapping("/registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Email on juba olemas.", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void signUp(@RequestBody UserInfoDto userInfoDto) {
        signupService.signUp(userInfoDto);

    }
}
