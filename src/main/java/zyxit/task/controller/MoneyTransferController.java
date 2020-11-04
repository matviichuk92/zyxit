package zyxit.task.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zyxit.task.service.AccountService;
import zyxit.task.service.UserService;

@Controller
@RequestMapping("/transfer")
public class MoneyTransferController {
    private final AccountService accountService;
    private final UserService userService;

    public MoneyTransferController(UserService userService, AccountService accountService, UserService userService1) {
        this.accountService = accountService;
        this.userService = userService1;
    }

    @GetMapping
    public String moneyTransfer() {
        return "transfer";
    }

    @PostMapping
    public void moneyTransfer(Authentication authentication, Long targetId, double summa) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long currentId = userService.findByName(userDetails.getUsername()).get().getId();
        accountService.moneyTransfer(currentId, targetId, summa);
    }
}
