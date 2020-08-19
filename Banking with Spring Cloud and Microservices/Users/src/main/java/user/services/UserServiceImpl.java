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
    public UserDto getUserByUsername(String username) {
        return mapper.userToUserDto(userRepository.findByUsername(username));
    }

    @Override
    public UserDto createNewUser(UserDto userDto) {
        return mapper.userToUserDto(userRepository.save(mapper.userDtoToUser(userDto)));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
