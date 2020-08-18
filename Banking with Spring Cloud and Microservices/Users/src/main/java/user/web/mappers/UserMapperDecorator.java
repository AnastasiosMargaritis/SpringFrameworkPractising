package user.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import user.domain.User;
import user.repositories.CountryRepository;
import user.repositories.UserRepository;
import user.services.country.CountryService;
import user.web.model.CountryDto;
import user.web.model.UserDto;

public abstract class UserMapperDecorator implements UserMapper {

    private CountryService countryService;
    private UserMapper userMapper;
    private CountryMapper countryMapper;
    private CountryRepository countryRepository;
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Autowired
    public void setCountryMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @Override
    public UserDto userToUserDto(User user, String code) {

        CountryDto country = countryService.getCountryByCode(code);

        if(countryRepository.findById(country.getId()) == null){
            countryRepository.save(countryMapper.countryDtoToCounty(country));
        }

        UserDto userDto = userToUserDto(user, code);
        userDto.setCountry(country);

        if(userRepository.findById(userDto.getId()) == null){
            userRepository.save(user);
        }
        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto, String code) {

        CountryDto countryDto = countryService.getCountryByCode(code);

        if(countryRepository.findById(countryDto.getId()) == null){
            countryRepository.save(countryMapper.countryDtoToCounty(countryDto));
        }

        User user = userMapper.userDtoToUser(userDto, code);
        user.setCountry(countryMapper.countryDtoToCounty(countryDto));

        return user;
    }
}
