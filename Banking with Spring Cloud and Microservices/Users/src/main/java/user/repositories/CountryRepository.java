package user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName(String name);
}
