package Shop.Customer.service.bar;

import Shop.Customer.domain.Drink;

import java.math.BigDecimal;
import java.util.List;

public interface BarService {

    BigDecimal order(String drinkType);

    List<Drink> getAllDrinks();
}
