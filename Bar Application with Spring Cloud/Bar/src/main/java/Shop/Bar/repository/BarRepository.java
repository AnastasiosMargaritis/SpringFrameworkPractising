package Shop.Bar.repository;

import Shop.Bar.domain.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Long> {
}
