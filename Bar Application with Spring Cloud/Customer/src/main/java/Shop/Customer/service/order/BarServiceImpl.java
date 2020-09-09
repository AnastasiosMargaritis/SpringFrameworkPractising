package Shop.Customer.service.order;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Service
public class BarServiceImpl implements BarService {

    private final String BAR_PATH = "/bar/order/";
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

        System.out.println(barServiceHost + BAR_PATH + drinkType);
        return restTemplate.getForObject(
                barServiceHost + BAR_PATH + drinkType, BigDecimal.class);
    }
}
