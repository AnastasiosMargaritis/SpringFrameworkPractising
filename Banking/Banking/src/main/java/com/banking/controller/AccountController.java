package com.banking.controller;

import com.banking.domain.Account;
import com.banking.domain.Money;
import com.banking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @RequestMapping("/withdraw/{id}")
    public Account withdraw(@PathVariable Long id, @RequestBody Money money){
        return this.accountService.withdraw(id, money);
    }
    
}
