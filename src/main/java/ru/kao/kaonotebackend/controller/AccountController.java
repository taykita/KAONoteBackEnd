package ru.kao.kaonotebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping("/account/{email}")
    public Account getAccount(@PathVariable("email") String email) {
        return service.getAccount(email);
    }

    /**
     * Checks if the account exists
     * @param email email data transfer object
     * @return true or false
     */
    @GetMapping("/account/exists/{email}")
    public boolean existsAccount(@PathVariable("email") String email) {
        return service.existsAccount(email);
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
