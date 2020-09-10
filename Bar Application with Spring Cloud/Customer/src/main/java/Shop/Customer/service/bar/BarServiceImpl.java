package Shop.Customer.service.bar;

import Shop.Customer.domain.Drink;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Service
public class BarServiceImpl implements BarService {

    private final String BAR_PATH = "/bar/order/";
    private final String DRINK_PATH = "/bar/drinks";
    private final RestTemplate restTemplate;

    private String barServiceHost;

    public BarServiceImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void setBarServiceHost(String barServiceHost) {
        this.barServiceHost = barServiceHost;
    }

    @Override
    public BigDecimal order(String drinkType) {

        return restTemplate.getForObject(
                barServiceHost + BAR_PATH + drinkType, BigDecimal.class);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return restTemplate.getForObject(
                barServiceHost + DRINK_PATH, List.class
        );
    }
}
