package com.security.bootstrap;

import com.security.domain.Authority;
import com.security.domain.Role;
import com.security.domain.User;
import com.security.repository.AuthorityRepository;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;



    @Override
    public void run(String... args) throws Exception {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        User user = new User();
        user.setId(1L);
        user.setUsername("AnasMarg");
//        user.setPassword(passwordEncoder.encode("1234"));
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRole(Role.USER);

        this.userRepository.save(user);

        Authority authority = new Authority();
        authority.setId(1L);
        authority.setUser(user);
        authority.setAuthority(Role.USER.toString());
        this.authorityRepository.save(authority);

        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority);
        System.out.println(user.getPassword().length());
        user.setAuthorities(authorities);

        String password = passwordEncoder.encode("1234");

        System.out.println(user.getPassword());
        System.out.println(password);

        System.out.println(passwordEncoder.matches(user.getPassword(), password));



    }
}
