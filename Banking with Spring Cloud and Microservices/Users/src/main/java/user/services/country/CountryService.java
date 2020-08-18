package user.services.country;

import user.web.model.CountryDto;

public interface CountryService {

    CountryDto getCountryByCode(String code);
}
