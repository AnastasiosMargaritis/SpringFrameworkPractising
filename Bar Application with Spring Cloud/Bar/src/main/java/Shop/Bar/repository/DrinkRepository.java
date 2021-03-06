package Shop.Bar.repository;

import Shop.Bar.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DrinkRepository extends JpaRepository<Drink, UUID> {

    Drink findByType(String type);
}
