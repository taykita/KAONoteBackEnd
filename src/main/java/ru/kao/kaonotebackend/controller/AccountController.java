package ru.kao.kaonotebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kao.kaonotebackend.dto.EmailDTO;
import ru.kao.kaonotebackend.entity.Account;
import ru.kao.kaonotebackend.service.AccountService;

/**
 * Account REST controller
 */
@RestController
public class AccountController {
    public AccountController(AccountService accountService) {
        this.service = accountService;
    }

    private final AccountService service;

    /**
     * Get account from database
     * @param email email data transfer object
     * @return found account
     */
    @GetMapping("/account")
    public Account getAccount(@RequestBody EmailDTO email) {
        return service.getAccount(email.email);
    }

    /**
     * Checks if the account exists
     * @param email email data transfer object
     * @return true or false
     */
    @GetMapping("/account/exists")
    public boolean existsAccount(@RequestBody EmailDTO email) {
        return service.existsAccount(email.email);
    }

    /**
     * Create account
     * @param account information about registered account
     * @return registered account
     */
    @PutMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return service.saveAccount(account);
    }
}
