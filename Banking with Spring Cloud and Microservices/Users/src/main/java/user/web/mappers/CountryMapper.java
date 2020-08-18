package user.web.mappers;

import org.mapstruct.Mapper;
import user.domain.Country;
import user.web.model.CountryDto;

@Mapper(uses = {UserMapper.class})
public interface CountryMapper {

    Country countryDtoToCounty(CountryDto countryDto);

    CountryDto countryToCountryDto(Country country);
}
