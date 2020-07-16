package com.banking.bootstrap;

import com.banking.domain.Account;
import com.banking.domain.Currencies;
import com.banking.domain.User;
import com.banking.repository.AccountRepository;
import com.banking.repository.CurrencyRepository;
import com.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Currencies> currencies = new ArrayList<>();

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


        //USERS CREATION
        User user = new User();
        user.setId(1L);
        user.setUsername("AnasMarg");
        user.setPassword("9311");

        User user1 = new User();
        user1.setId(2L);
        user1.setUsername("AnthiMl");
        user1.setPassword("1881");
        //


        //ACCOUNTS CREATION
        Account account = new Account();
        account.setId(1L);
        account.setIban("SE35 5000 0000 0549 1000 0003");
        account.getCurrencies().add(dollar);
        account.getCurrencies().add(euro);
        account.getCurrencies().add(chf);
        account.getCurrencies().add(gbp);
        account.getCurrencies().add(cad);

        Account account1 = new Account();
        account1.setId(2L);
        account1.setIban("CH93 0076 2011 6238 5295");
        account1.getCurrencies().add(dollar);
        account1.getCurrencies().add(euro);
        account1.getCurrencies().add(chf);
        account1.getCurrencies().add(gbp);
        account1.getCurrencies().add(cad);

        this.accountRepository.save(account);
        this.accountRepository.save(account1);

        dollar.getAccount().add(account);
        dollar.getAccount().add(account1);

        euro.getAccount().add(account);
        euro.getAccount().add(account1);

        chf.getAccount().add(account);
        chf.getAccount().add(account1);

        gbp.getAccount().add(account);
        gbp.getAccount().add(account1);

        cad.getAccount().add(account);
        cad.getAccount().add(account1);

        currencies.add(dollar);
        currencies.add(euro);
        currencies.add(chf);
        currencies.add(gbp);
        currencies.add(cad);
        this.currencyRepository.saveAll(currencies);

        for(Currencies c: currencies){
            account.getMoney().put(c.getCurrency(), 0d);
            account1.getMoney().put(c.getCurrency(), 0d);
        }

        this.accountRepository.save(account);
        this.accountRepository.save(account1);

        user.setAccount(account);
        user1.setAccount(account1);
        this.userRepository.save(user);
        this.userRepository.save(user1);
    }
}
