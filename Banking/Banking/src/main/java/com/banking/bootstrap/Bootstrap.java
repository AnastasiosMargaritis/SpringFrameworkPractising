package com.banking.bootstrap;

import com.banking.domain.Account;
import com.banking.domain.Currencies;
import com.banking.domain.User;
import com.banking.repository.AccountRepository;
import com.banking.repository.CurrencyRepository;
import com.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.HashSet;
import java.util.Set;

public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public void run(String... args) throws Exception {

        Set<Currencies> currencies = new HashSet<>();

        Currencies dollar = new Currencies();
        dollar.setId(1L);
        dollar.setCurrency("USD");
        dollar.setRate(0.88);

        Currencies euro = new Currencies();
        euro.setId(2L);
        euro.setCurrency("EUR");
        euro.setRate(1d);
        euro.setEnabled(true);

        Currencies chf = new Currencies();
        chf.setId(3L);
        chf.setCurrency("CHF");
        chf.setRate(0.94);

        Currencies gbp =new Currencies();
        gbp.setId(4L);
        gbp.setCurrency("GBP");
        gbp.setRate(1.10);

        Currencies cad = new Currencies();
        cad.setId(5L);
        cad.setCurrency("CAD");
        cad.setRate(0.66);

        currencies.add(dollar);
        currencies.add(euro);
        currencies.add(chf);
        currencies.add(gbp);
        currencies.add(cad);
        this.currencyRepository.saveAll(currencies);



        User user = new User();
        user.setId(1L);
        user.setUsername("AnasMarg");
        user.setPassword("9311");

        User user1 = new User();
        user1.setId(2L);
        user1.setUsername("AnthiMl");
        user1.setPassword("1881");

        this.userRepository.save(user);
        this.userRepository.save(user1);

        Account account = new Account();
        account.setId(1L);
        account.setIban("SE35 5000 0000 0549 1000 0003");
        account.setUser(user);
        account.setCurrencies(currencies);

        Account account1 = new Account();
        account1.setId(2L);
        account1.setIban("CH93 0076 2011 6238 5295 7\n");
        account1.setUser(user1);
        account1.setCurrencies(currencies);

        this.accountRepository.save(account);
        this.accountRepository.save(account1);
    }
}
