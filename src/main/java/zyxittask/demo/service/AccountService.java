package zyxittask.demo.service;

import zyxittask.demo.model.Account;
import zyxittask.demo.model.User;

public interface AccountService {
    Account add(User user);

    void moneyTransfer(Long currentId, Long targetId, double summa);
}
