package Shop.Customer.service.bar;

import Shop.Customer.domain.Drink;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Profile("local-discovery")
@Slf4j
@RequiredArgsConstructor
public class BarServiceFeign implements BarService {

    private final BarServiceFeignClient client;

    @Override
    public BigDecimal order(String drinkType) {
        return client.order(drinkType);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return client.getAllDrinks();
    }
}
