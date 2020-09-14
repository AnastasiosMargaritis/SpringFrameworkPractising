package Shop.Customer.service.bar;

import Shop.Customer.domain.Drink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Profile("!local-discovery")
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Service
public class BarServiceImpl implements BarService {

    public static final String BAR_PATH = "/bar/order/{drinkType}";
    public static final String DRINK_PATH = "/bar/drinks";
    private final RestTemplate restTemplate;

    private String barServiceHost;

    public BarServiceImpl(RestTemplateBuilder restTemplate,
                          @Value("${sfg.brewery.bar-user}")String barUser,
                          @Value("${sfg.brewery.bar-password}")String barPassword) {
        this.restTemplate = restTemplate
                .basicAuthentication(barUser, barPassword)
                            .build();
    }

    public void setBarServiceHost(String barServiceHost) {
        this.barServiceHost = barServiceHost;
    }

    @Override
    public BigDecimal order(String drinkType) {

        return restTemplate.getForObject(
                barServiceHost + BAR_PATH , BigDecimal.class);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return restTemplate.getForObject(
                barServiceHost + DRINK_PATH, List.class
        );
    }
}
