package user.services.country;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user.domain.Country;

@ConfigurationProperties(prefix = "sfg.banking", ignoreUnknownFields = false)
@Service
public class CountryServiceImpl implements CountryService {

    private final String  COUNTRY_PATH = "/api/v1/country/code/";
    private final RestTemplate restTemplate;

    private String countryServiceHost;

    public CountryServiceImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void setCountryServiceHost(String serviceHost) {
        this.countryServiceHost = serviceHost;
    }

    @Override
    public Country getCountryByCode(String code) {
        return restTemplate.getForObject(
                countryServiceHost + COUNTRY_PATH + code, Country.class
        );
    }
}
