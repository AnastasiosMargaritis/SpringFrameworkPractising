package Shop.Customer.service.bar;

import Shop.Customer.domain.Drink;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "bar-service")
public interface BarServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = BarServiceImpl.BAR_PATH)
    BigDecimal order(@PathVariable String drinkType);

    @RequestMapping(method = RequestMethod.GET, value = BarServiceImpl.DRINK_PATH)
    List<Drink> getAllDrinks();
}
