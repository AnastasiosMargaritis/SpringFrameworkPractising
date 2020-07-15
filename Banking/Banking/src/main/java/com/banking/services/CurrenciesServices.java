package com.banking.services;

import com.banking.domain.Currencies;
import com.banking.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrenciesServices {


    @Autowired
    public CurrencyRepository currencyRepository;

    public List<Currencies> getAllCurrencies(){
        return this.currencyRepository.findAll();
    }
}

