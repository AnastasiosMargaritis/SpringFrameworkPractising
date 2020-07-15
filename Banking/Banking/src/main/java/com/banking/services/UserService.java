package com.banking.services;

import com.banking.domain.User;
import com.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService account;

    public User newUser(User user){

        user.setAccount(this.account.createDefaultAccount());

        return this.userRepository.save(user);
    }


    public void deleteUser(User user){
        this.userRepository.delete(user);
    }
}
