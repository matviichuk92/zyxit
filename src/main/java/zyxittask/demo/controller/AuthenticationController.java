package zyxittask.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zyxittask.demo.model.User;
import zyxittask.demo.security.AuthenticationService;

@Controller
@RequestMapping("/registration")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String register(User user) {
        authenticationService.registration(user.getName(), user.getPassword());
        return "redirect:/login";
    }
}
