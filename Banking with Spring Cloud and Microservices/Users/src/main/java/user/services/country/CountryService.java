package user.services.country;

import user.domain.Country;

public interface CountryService {

    Country getCountryByCode(String code);
}
