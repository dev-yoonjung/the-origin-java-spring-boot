package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.mission.basic.auth.CommunityUserDetailsService;
import springboot.mission.basic.controller.dto.UserDto;
import springboot.mission.basic.service.UserService;

import java.util.Collection;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final CommunityUserDetailsService userManager;

    public UserController(
            UserService userService,
            CommunityUserDetailsService userDetailsService
    ) {
        this.userService = userService;
        this.userManager = userDetailsService;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> readUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.readUser(id));
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> readUserAll(){
        return ResponseEntity.ok(this.userService.readUserAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        this.userService.updateUser(id, userDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable("id") Long id){
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("login")
    public String login(){
        return "login-form";
    }

    @GetMapping("signup")
    public String signUp() {
        return "signup-form";
    }

    @PostMapping("signup")
    public String signUpPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password_check") String passwordCheck,
            @RequestParam(value = "is_shop_owner", defaultValue = "false") Boolean isShopOwner
    ) {
        if (!password.equals(passwordCheck)) {
            return "redirect:/user/signup?error=password_check";
        }
        userManager.createUser(username, password, isShopOwner);

        return "redirect:/user/login";
    }
}
