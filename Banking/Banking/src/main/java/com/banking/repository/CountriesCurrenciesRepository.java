package com.banking.repository;

import com.banking.domain.APIPOJORetrieve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesCurrenciesRepository extends JpaRepository<APIPOJORetrieve, Long> {
}
