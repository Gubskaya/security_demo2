package security.demo2_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import security.demo2_security.entities.User;
import security.demo2_security.services.UserService;

import java.security.Principal;

@RestController
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "Home page";
    }

    @GetMapping("/authenticated")
    public String pageForAuthUsers(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "Hello, authenticated user: " + user.getUsername() + " " + user.getEmail();
    }
}
