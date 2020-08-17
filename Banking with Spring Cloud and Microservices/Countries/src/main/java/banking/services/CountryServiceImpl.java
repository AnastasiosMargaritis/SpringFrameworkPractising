package banking.services;

import banking.repositories.CountriesRepository;
import banking.web.mappers.CountryMapper;
import banking.web.models.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountriesRepository repository;
    private final CountryMapper mapper;

    @Override
    public CountryDto getCountryByName(String name) {
        return mapper.countryToCountryDto(this.repository.findByName(name));
    }

    @Override
    public CountryDto getCountryByCode(String code) {
        if (code.length() == 2){
            return mapper.countryToCountryDto(this.repository.findByAlpha2Code(code));
        }else {
            return mapper.countryToCountryDto(this.repository.findByAlpha3Code(code));
        }
    }
}
