package user.services;

import user.domain.User;

public interface UserService {

    User getUserByUsername(String username);

    User createNewUser(User user);

    void deleteUserById(Long id);
}
