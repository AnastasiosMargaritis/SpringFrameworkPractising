package banking.bootstrap;

import banking.domain.APIPOJORetrieve;
import banking.domain.Country;
import banking.repositories.CountriesRepository;
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
    private CountriesRepository countriesRepository;

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        final String url = "https://restcountries.eu/rest/v2/all?fields=name;alpha2Code;alpha3Code;currencies";
        RestTemplate restTemplate = new RestTemplate();

        JsonNode json = restTemplate.getForObject(url, JsonNode.class);

        List<Country> countries = mapper.convertValue(
                json,
                new TypeReference<List<Country>>() {
                }
        );

        for(Country country: countries){

            APIPOJORetrieve object = new APIPOJORetrieve();
            object.setName(country.getName());
            object.setAlpha2Code(country.getAlpha2Code());
            object.setAlpha3Code(country.getAlpha3Code());
            object.setCurrencyCode(country.getCurrencies().get(0).getCode());
            object.setCurrencyName(country.getCurrencies().get(0).getName());

            this.countriesRepository.save(object);
        }
    }
}
