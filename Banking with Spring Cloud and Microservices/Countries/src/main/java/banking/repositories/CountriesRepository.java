package banking.repositories;

import banking.domain.APIPOJORetrieve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<APIPOJORetrieve, Long> {

    APIPOJORetrieve findByName(String name);

    APIPOJORetrieve findByAlpha2Code(String code);

    APIPOJORetrieve findByAlpha3Code(String code);
}
