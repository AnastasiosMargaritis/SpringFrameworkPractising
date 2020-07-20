package com.banking.controller;

import com.banking.domain.Account;
import com.banking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    @RequestMapping("/{id}")
    public Account getUsersAccount(@PathVariable Long id){
        return this.accountService.getUsersAccount(id);
    }

//    @PostMapping
//    @RequestMapping("/deposit/{id}")
//    public Account deposit(@PathVariable Long id, @RequestBody Money money){
////        return this.accountService.deposit(id, money);
//    }

//    @PutMapping
//    @RequestMapping("/enable/{id}")
//    public Account enableCurrency(@PathVariable Long id, @RequestParam String currency){
////        return this.accountService.activateCurrency(id, currency);
//    }

    @GetMapping
    @RequestMapping("/rates")
    public String  getAllRates(){
        final String url = "https://api.exchangeratesapi.io/latest";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        return result;
    }
}
