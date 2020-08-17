package banking.web.mappers;

import banking.domain.APIPOJORetrieve;
import banking.web.models.CountryDto;
import org.mapstruct.Mapper;

@Mapper
public interface CountryMapper {

    CountryDto countryToCountryDto(APIPOJORetrieve country);

    APIPOJORetrieve countryDtoΤoCountry(CountryDto countryDto);
}
