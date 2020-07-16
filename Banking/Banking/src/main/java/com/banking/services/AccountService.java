package com.banking.services;

import com.banking.domain.Account;
import com.banking.domain.Money;
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

    public Account getUsersAccount(Long id){
        return this.accountRepository.findAccountByUserId(id);
    }

    public Account deposit(Long id, Money money){

        Account account = this.accountRepository.findAccountByUserId(id);

        if(account.getMoney().containsKey(money.getCurrency()) && this.currenciesServices.getCurrencyByCurrency(money.getCurrency()).isEnabled()){
            account.getMoney().put(money.getCurrency(), account.getMoney().get(money.getCurrency()) + money.getAmount());
        }else{
            throw new RuntimeException("The currency you are trying to deposit is not enabled in your account. " +
                    "Please enable this currency into your account first.");
        }

        return this.accountRepository.save(account);
    }

    public Account activateCurrency(Long id, String currency){
        Account account = this.accountRepository.findAccountByUserId(id);

        this.currenciesServices.activateCurrency(this.currenciesServices.getCurrencyByCurrency(currency).getId());

        return this.accountRepository.save(account);
    }
}
