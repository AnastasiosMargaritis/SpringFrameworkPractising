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

        System.out.println(drinkType);
        System.out.println(drink);

        if(drink.getQuantity() < 1){
            drinkService.refill(drink.getId());
        }else {
            drink.setQuantity(drink.getQuantity() - 1);
        }

        drinkRepository.save(drink);

        return drink.getPrice();
    }
}
