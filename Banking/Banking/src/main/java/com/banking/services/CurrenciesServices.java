package com.banking.services;

import com.banking.domain.Currencies;
import com.banking.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrenciesServices {


    @Autowired
    public CurrencyRepository currencyRepository;

    public List<Currencies> getAllCurrencies(){
        return this.currencyRepository.findAll();
    }

    public Currencies getCurrencyByCurrency(String currency){
        return this.currencyRepository.findByCurrency(currency);
    }

    public Optional<Currencies> activateCurrency(Long id){
        return this.currencyRepository.findById(id)
                .map(currencies -> {
                    currencies.setEnabled(true);
                    return this.currencyRepository.save(currencies);
                });
    }
}

