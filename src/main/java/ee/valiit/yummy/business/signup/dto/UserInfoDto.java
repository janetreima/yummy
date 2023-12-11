package ee.valiit.yummy.business.signup.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {


    @NotNull
    @Size(max = 255)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Size(max = 255)
    private String email;

}
