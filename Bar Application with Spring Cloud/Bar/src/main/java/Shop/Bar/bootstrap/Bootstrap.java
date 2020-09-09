package Shop.Bar.bootstrap;

import Shop.Bar.domain.Bar;
import Shop.Bar.domain.Drink;
import Shop.Bar.domain.DrinkType;
import Shop.Bar.repository.BarRepository;
import Shop.Bar.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final BarRepository barRepository;
    private final DrinkRepository drinkRepository;

    @Override
    public void run(String... args) throws Exception {

        Bar bar = new Bar().builder()
                .id(1L)
                .build();

        barRepository.save(bar);

        Drink drink = new Drink().builder()
                        .id(1L)
                        .type(DrinkType.BEER.toString())
                        .price(new BigDecimal("3.99"))
                        .quantity(100)
                        .bar(bar)
                        .build();

        Drink drink1 = new Drink().builder()
                        .id(2L)
                        .type(DrinkType.VODKA.toString())
                        .price(new BigDecimal("7.99"))
                        .quantity(10)
                        .bar(bar)
                        .build();

        Drink drink2 = new Drink().builder()
                        .id(3L)
                        .type(DrinkType.WHISKEY.toString())
                        .price(new BigDecimal("8.99"))
                        .quantity(12)
                        .bar(bar)
                        .build();

        Drink drink3 = new Drink().builder()
                        .id(4L)
                        .type(DrinkType.WINE.toString())
                        .price(new BigDecimal("5.99"))
                        .quantity(100)
                        .bar(bar)
                        .build();

        drinkRepository.save(drink);
        drinkRepository.save(drink1);
        drinkRepository.save(drink2);
        drinkRepository.save(drink3);
    }
}
