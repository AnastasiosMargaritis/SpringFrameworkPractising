package Shop.Bar.service;

import Shop.Bar.domain.Drink;
import Shop.Bar.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public void refill(UUID id) {
        Drink drink = drinkRepository.findById(id).get();

        drink.setQuantity(drink.getQuantity() + 10);

        drinkRepository.save(drink);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }
}
