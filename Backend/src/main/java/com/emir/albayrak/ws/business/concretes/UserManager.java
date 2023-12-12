package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.UserService;
//import com.emir.albayrak.ws.dataaccess.FakeUserRepository;
import com.emir.albayrak.ws.dataaccess.UserRepository;
import com.emir.albayrak.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
