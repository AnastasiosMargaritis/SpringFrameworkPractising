package com.banking.services;

import com.banking.domain.Account;
import com.banking.domain.CurrencyConverter;
import com.banking.domain.Money;
import com.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Account createDefaultAccount(){

        Account account = new Account();
        account.setIban(account.generateIBAN());
        account.getMoney().put("EUR", 0d);

        return this.accountRepository.save(account);
    }

    public Account deposit(Money money, Long id){

        if(this.getUsersAccount(id).getMoney().containsKey(money.getCurrency())){
            this.getUsersAccount(id).getMoney().put(money.getCurrency(), this.getUsersAccount(id).getMoney().get(money.getCurrency()) + money.getAmount());
        }else{
            this.getUsersAccount(id).getMoney().put(money.getCurrency(), money.getAmount());
        }
        return this.accountRepository.save(this.getUsersAccount(id));
    }

    public Account withdraw(Long id, Money money){
        if(this.getUsersAccount(id).getMoney().containsKey(money.getCurrency()) &&
                this.getUsersAccount(id).getMoney().get(money.getCurrency()) >= money.getAmount()){
            (this.getUsersAccount(id)).getMoney().put(money.getCurrency(),
                    this.getUsersAccount(id).getMoney().get(money.getCurrency()) - money.getAmount());
        }

        return this.accountRepository.save(this.getUsersAccount(id));
    }

    public Account exchange(Long id, CurrencyConverter currencyConverter) throws Exception {
        this.getUsersAccount(id).getMoney().put(currencyConverter.getTo(),
                    this.getUsersAccount(id).getMoney().get(currencyConverter.getFrom())*currencyConverter.sendPost() +
                    this.getUsersAccount(id).getMoney().get(currencyConverter.getTo()));

        return this.accountRepository.save(this.getUsersAccount(id));
    }

    public Account getUsersAccount(Long id){
        return this.accountRepository.findAccountByUserId(id);
    }
}
