package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.LoginService;
import com.emir.albayrak.ws.dataaccess.UserRepository;
import com.emir.albayrak.ws.model.User;
import com.emir.albayrak.ws.model.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginManager implements LoginService {
    private UserRepository userRepository;

    @Autowired
    public LoginManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findUserByCredentials(UserCredentials userCredentials) {
        return userRepository.findByUsernameAndPassword
                (userCredentials.getUsername(), userCredentials.getPassword());
    }
}
