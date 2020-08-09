package com.banking.controller;

import com.banking.domain.Account;
import com.banking.domain.Money;
import com.banking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    @RequestMapping("/deposit/{id}")
    public Account deposit(@PathVariable Long id, @RequestBody Money money){
        return this.accountService.deposit(money, id);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return this.accountService.getUsersAccount(id);
    }

    @GetMapping
    public List<Account> getAllAccounts(){
       return this.accountService.getAllAccounts();
    }
}
