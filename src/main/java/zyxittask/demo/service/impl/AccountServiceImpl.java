package zyxittask.demo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zyxittask.demo.model.Account;
import zyxittask.demo.model.User;
import zyxittask.demo.repository.AccountRepository;
import zyxittask.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Value("${start_amount}")
    private int start_amount;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account add(User user) {
        Account account = new Account();
        account.setUser(user);
        account.setBalance(start_amount);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account get(Long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public void moneyTransfer(Long currentId, Long targetId, double summa) {
        Account currentAccount = accountRepository.getOne(currentId);
        currentAccount.setBalance(currentAccount.getBalance() - summa);
        accountRepository.save(currentAccount);
        Account targetAccount = accountRepository.getOne(targetId);
        targetAccount.setBalance(targetAccount.getBalance() + summa);
        accountRepository.save(targetAccount);
    }
}
