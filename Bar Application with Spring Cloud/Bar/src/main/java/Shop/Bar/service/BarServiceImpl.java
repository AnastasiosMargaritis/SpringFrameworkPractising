package Shop.Bar.service;

import Shop.Bar.domain.Drink;
import Shop.Bar.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BarServiceImpl implements BarService {

    private final DrinkRepository drinkRepository;
    private final DrinkService drinkService;

    @Override
    public BigDecimal order(String drinkType) {

        Drink drink = drinkRepository.findByType(drinkType);

        if(drink.getQuantity() < 1){
            return new BigDecimal("Out of Stock!!");
        }else {
            drink.setQuantity(drink.getQuantity() - 1);
        }

        drinkRepository.save(drink);

        return drink.getPrice();
    }
}
