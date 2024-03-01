package ru.kao.kaonotebackend.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kao.kaonotebackend.entity.Account;
import ru.kao.kaonotebackend.repository.AccountRepository;
import ru.kao.kaonotebackend.util.LoggerUtil;

@Service
public class AccountService {
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.repository = accountRepository;
    }

    private final Logger logger = LoggerUtil.getLogger(AccountService.class);

    private final AccountRepository repository;

    public Account getAccount(String email) {
        Account account = repository.findByEmail(email);
        logger.debug("Returning the account - {}", account);
        return account;
    }

    public boolean existsAccount(String email) {
        return repository.existsAccountByEmail(email);
    }

    public Account saveAccount(Account account) {
        logger.debug("Saving account in the database.\nAccount - {}", account);
        Account registratedAccount = repository.save(account);
        logger.debug("Account has been saved in the database.\nResult account - {}", registratedAccount);
        return registratedAccount;
    }
}
