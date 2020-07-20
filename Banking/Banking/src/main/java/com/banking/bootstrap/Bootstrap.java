package com.banking.bootstrap;

import com.banking.domain.APIPOJORetrieve;
import com.banking.domain.Country;
import com.banking.repository.CountriesCurrenciesRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private CountriesCurrenciesRepository countriesCurrenciesRepository;


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
    }
}
