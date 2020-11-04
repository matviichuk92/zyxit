package zyxit.task.security;

import org.springframework.stereotype.Service;
import zyxit.task.model.Role;
import zyxit.task.model.User;
import zyxit.task.service.AccountService;
import zyxit.task.service.UserService;
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
