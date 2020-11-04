package zyxittask.demo.security;

import org.springframework.stereotype.Service;
import zyxittask.demo.model.Role;
import zyxittask.demo.model.User;
import zyxittask.demo.service.AccountService;
import zyxittask.demo.service.UserService;
import java.util.Collections;

@Service
public class AuthenticationImpl implements AuthenticationService {
    private final UserService userService;
    private final AccountService accountService;

    public AuthenticationImpl(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void registration(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setRoles(Collections.singleton(Role.USER));
        userService.add(user);
        accountService.add(user);
    }
}
