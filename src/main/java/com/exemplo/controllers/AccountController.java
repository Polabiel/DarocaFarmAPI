package com.exemplo.controllers;

import com.exemplo.models.Account;
import com.exemplo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository repository;

    public void add(Account account) {
        account.getNumber();
        repository.save(account);
    }
}
