package com.banking.services;

import com.banking.domain.Account;
import com.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CurrenciesServices currenciesServices;


    public Account createDefaultAccount(){

        Account account = new Account();
        account.setIban(account.generateIBAN());

        account.setCurrencies(this.currenciesServices.getAllCurrencies());
        account.initializeAccount(account.getCurrencies());

        return this.accountRepository.save(account);
    }
}
