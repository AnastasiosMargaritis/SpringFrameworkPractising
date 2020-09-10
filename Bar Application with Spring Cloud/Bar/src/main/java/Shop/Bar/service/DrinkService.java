package Shop.Bar.service;

import Shop.Bar.domain.Drink;

import java.util.List;
import java.util.UUID;

public interface DrinkService {

    void refill(UUID id);

    List<Drink> getAllDrinks();
}
