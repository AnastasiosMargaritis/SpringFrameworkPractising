package com.banking.bootstrap;

import com.banking.domain.APIPOJORetrieve;
import com.banking.domain.Country;
import com.banking.domain.User;
import com.banking.repository.CountriesCurrenciesRepository;
import com.banking.repository.UserRepository;
import com.banking.services.AccountService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private CountriesCurrenciesRepository countriesCurrenciesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;


    @Override
    public void run(String... args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        final String url = "https://restcountries.eu/rest/v2/all?fields=name;alpha2Code;alpha3Code;currencies";
        RestTemplate restTemplate = new RestTemplate();

        JsonNode json = restTemplate.getForObject(url, JsonNode.class);

        List<Country> countries = objectMapper.convertValue(
                json,
                new TypeReference<List<Country>>() {
                }
        );

        for(int i = 0; i< countries.size(); i++){
            APIPOJORetrieve apipojoRetrieve = new APIPOJORetrieve();
            apipojoRetrieve.setName(countries.get(i).getName());
            apipojoRetrieve.setAlpha2Code(countries.get(i).getAlpha2Code());
            apipojoRetrieve.setAlpha3Code(countries.get(i).getAlpha3Code());
            apipojoRetrieve.setCurrencyCode(countries.get(i).getCurrencies().get(0).getCode());
            apipojoRetrieve.setCurrencyName(countries.get(i).getCurrencies().get(0).getName());

            this.countriesCurrenciesRepository.save(apipojoRetrieve);
        }

//        CurrencyConverter currencyConverter = new CurrencyConverter("EUR", "USD", 11.70);
//        currencyConverter.sendPost();


        Set<User> users = new HashSet<>();

        User user = new User();
        user.setId(1L);
        user.setUsername("AnasMarg");
        user.setPassword("1234");
        user.setAccount(this.accountService.createDefaultAccount());

        User user1 = new User();
        user1.setId(2L);
        user1.setUsername("AnthiMolozi");
        user1.setPassword("2434");
        user1.setAccount(this.accountService.createDefaultAccount());

        User user2 = new User();
        user2.setId(3L);
        user2.setUsername("ElMargar");
        user2.setPassword("2323");
        user2.setAccount(this.accountService.createDefaultAccount());

        users.add(user);
        users.add(user1);
        users.add(user2);

        this.userRepository.saveAll(users);
    }
}
