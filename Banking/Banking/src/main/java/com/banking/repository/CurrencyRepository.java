package com.banking.repository;

import com.banking.domain.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepository extends JpaRepository<Currencies, Long> {

    Currencies findByCurrency(String currency);
}
