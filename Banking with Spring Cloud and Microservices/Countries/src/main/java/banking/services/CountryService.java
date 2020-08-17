package banking.services;

import banking.web.models.CountryDto;

public interface CountryService {

    CountryDto getCountryByName(String name);

    CountryDto getCountryByCode(String code);
}
