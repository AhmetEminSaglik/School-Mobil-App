package com.emir.albayrak.ws.business.abstracts;

import com.emir.albayrak.ws.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);
}
