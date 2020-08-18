package user.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.repositories.UserRepository;
import user.web.mappers.UserMapper;
import user.web.model.UserDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public UserDto createNewUser(UserDto userDto, String countryCode) {
        return mapper.userToUserDto(mapper.userDtoToUser(userDto, countryCode),countryCode);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
