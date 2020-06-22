package com.security.service;

import com.security.repository.UserRepository;
import com.security.domain.User;
import com.security.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }
}
