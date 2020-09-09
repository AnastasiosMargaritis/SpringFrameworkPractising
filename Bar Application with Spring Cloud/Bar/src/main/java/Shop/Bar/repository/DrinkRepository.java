package Shop.Bar.repository;

import Shop.Bar.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Drink findByType(String type);
}
