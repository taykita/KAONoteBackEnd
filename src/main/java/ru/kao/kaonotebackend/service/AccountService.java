package ru.kao.kaonotebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kao.kaonotebackend.entity.Account;
import ru.kao.kaonotebackend.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.repository = accountRepository;
    }

    private final AccountRepository repository;

    public Account getAccount(String email) {
        return repository.findByEmail(email);
    }

    public boolean existsAccount(String email) {
        return repository.existsAccountByEmail(email);
    }

    public Account saveAccount(Account account) {
        return repository.save(account);
    }
}
