package zyxittask.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zyxittask.demo.exception.MoneyTransferException;
import zyxittask.demo.service.AccountService;
import zyxittask.demo.service.UserService;

@Controller
@RequestMapping("/transfer")
public class MoneyTransferController {
    private final AccountService accountService;
    private final UserService userService;

    public MoneyTransferController(UserService userService, AccountService accountService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping
    public String moneyTransfer() {
        return "transfer";
    }

    @PostMapping
    public void moneyTransfer(Authentication authentication, Long targetId, double summa)
            throws MoneyTransferException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long currentId = userService.findByName(userDetails.getUsername()).get().getId();
        try {
            accountService.moneyTransfer(currentId, targetId, summa);
        } catch (Exception e) {
            throw new MoneyTransferException("User doesn't exist or you haven't enough money!");
        }
    }
}
