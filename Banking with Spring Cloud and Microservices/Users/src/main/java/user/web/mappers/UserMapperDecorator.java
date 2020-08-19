package user.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import user.domain.User;
import user.repositories.CountryRepository;
import user.services.country.CountryService;
import user.web.model.CountryDto;
import user.web.model.UserDto;

public abstract class UserMapperDecorator implements UserMapper {

    private CountryService countryService;
    private UserMapper userMapper;
    private CountryRepository repository;
    private CountryMapper countryMapper;


    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setRepository(CountryRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setCountryMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @Override
    public UserDto userToUserDto(User user) {
        UserDto dto = userMapper.userToUserDto(user);
        CountryDto country = countryService.getCountryByCode(user.getCountryCode());

        if(repository.findByName(country.getName()) == null){
            repository.save(countryMapper.countryDtoToCounty(country));
        }

        dto.setCountry(country);
        country.getUsers().add(dto);
        return  dto;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {

        return userMapper.userDtoToUser(userDto);
    }
}
