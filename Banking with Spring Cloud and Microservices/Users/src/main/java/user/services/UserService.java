package user.services;

import user.web.model.UserDto;

public interface UserService {

    UserDto createNewUser(UserDto userDto, String countryName);

    void deleteUserById(Long id);
}
