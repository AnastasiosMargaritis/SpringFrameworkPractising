package com.banking.bootstrap;

import com.banking.repository.AccountRepository;
import com.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void run(String... args) throws Exception {

        final String url = "https://restcountries.eu/rest/v2/all?fields=name;alpha2Code;alpha3Code";
        RestTemplate restTemplate = new RestTemplate();

        
    }
}
