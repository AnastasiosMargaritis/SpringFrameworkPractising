package com.security.bootstrap;

import com.security.UserRepository;
import com.security.domain.Role;
import com.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRepository  userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("AnasMarg");
        user.setPassword("1234");
        user.setRole(Role.USER);

        this.userRepository.save(user);

    }
}
