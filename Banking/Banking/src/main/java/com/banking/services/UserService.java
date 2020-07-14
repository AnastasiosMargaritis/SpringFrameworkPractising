package com.banking.services;

import com.banking.domain.Account;
import com.banking.domain.User;
import com.banking.repository.AccountRepository;
import com.banking.repository.CurrencyRepository;
import com.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    public User newUser(User user){

        Account account = new Account();
        account.setIban(account.generateIBAN());
        account.setCurrencies(this.currencyRepository.findAll());
        this.accountRepository.save(account);

        user.setAccount(account);

        return this.userRepository.save(user);
    }



    public void deleteUser(User user){
        this.userRepository.delete(user);
    }
}
