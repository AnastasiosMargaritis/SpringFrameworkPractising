package user.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.domain.User;
import user.repositories.UserRepository;
import user.services.country.CountryService;
import user.web.mappers.CountryMapper;
import user.web.mappers.UserMapper;
import user.web.model.UserDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final CountryMapper countryMapper;
    private final CountryService countryService;

    @Override
    public UserDto getUserByUsername(String username) {
        return mapper.userToUserDto(userRepository.findByUsername(username));
    }

    @Override
    public UserDto createNewUser(UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);

        return mapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
