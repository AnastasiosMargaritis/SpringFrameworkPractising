package com.banking.repository;

import com.banking.domain.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currencies, Long> {
}
