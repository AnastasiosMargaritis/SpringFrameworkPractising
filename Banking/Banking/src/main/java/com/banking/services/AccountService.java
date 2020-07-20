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

        return this.accountRepository.save(account);
    }

    public Account getUsersAccount(Long id){
        return this.accountRepository.findAccountByUserId(id);
    }

//    public Account deposit(Long id, Money money){
//
//    }
//
//    public Account activateCurrency(Long id, String currency){
//
//    }
}
