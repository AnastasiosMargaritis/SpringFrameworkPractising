package user.services;

import user.web.model.UserDto;

public interface UserService {

    UserDto getUserByUsername(String username);

    UserDto createNewUser(UserDto userDto);

    void deleteUserById(Long id);
}
