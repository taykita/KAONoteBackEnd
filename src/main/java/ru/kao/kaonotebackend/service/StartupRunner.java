package ru.kao.kaonotebackend.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.kao.kaonotebackend.entity.Account;
import ru.kao.kaonotebackend.repository.AccountRepository;
import ru.kao.kaonotebackend.util.LoggerUtil;


@Service
@Profile("DEV")
public class StartupRunner implements CommandLineRunner {
    private final Logger LOGGER = LoggerUtil.getLogger(StartupRunner.class);

    @Autowired
    public StartupRunner(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private final AccountRepository accountRepository;
    @Override
    public void run(String... args) throws Exception {
        LOGGER.debug("Initial filling of the database started");

        Account adminAccount = new Account("admin@admin", "Admin", "Adminov",
                "qwe@qwe", false, false, false, true);
        if (!accountRepository.existsAccountByEmail(adminAccount.email))
            accountRepository.save(adminAccount);

        LOGGER.debug("Initial filling of the database ended");
    }
}
