package zyxit.task.service;

import zyxit.task.model.Account;
import zyxit.task.model.User;

public interface AccountService {
    Account add(User user);

    void moneyTransfer(Long currentId, Long targetId, double summa);
}
