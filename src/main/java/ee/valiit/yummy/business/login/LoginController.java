package ee.valiit.yummy.business.login;

import ee.valiit.yummy.business.login.dto.LoginDto;
import ee.valiit.yummy.business.recipe.RecipeDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Sisse logimine. Tagastab userId ja roleName",
            description = "Süsteemist otsitakse username ja password abil kasutajat, kelle konto on aktiivne.")
    public LoginDto login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }

}
