package user.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import user.domain.Country;
import user.domain.User;
import user.repositories.CountryRepository;
import user.services.country.CountryService;
import user.web.model.UserDto;

public abstract class UserMapperDecorator implements UserMapper {

    private CountryService service;
    private UserMapper mapper;
    private CountryMapper countryMapper;
    private CountryRepository repository;


    @Autowired
    public void setRepository(CountryRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setService(CountryService service) {
        this.service = service;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setCountryMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @Override
    public UserDto userToUserDto(User user, String code) {
        UserDto userDto = mapper.userToUserDto(user, code);

        userDto.setCountry(service.getCountryByCode(code));

        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto, String code) {
        User user = mapper.userDtoToUser(userDto, code);

        Country country = countryMapper.countryDtoToCounty(service.getCountryByCode(code));

        repository.save(country);

        user.setCountry(country);

        return user;

    }
}
