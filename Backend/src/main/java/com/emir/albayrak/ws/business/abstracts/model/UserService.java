package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.User;
import utility.result.DataResult;

import java.util.List;

public interface UserService {
    List<User> findAll();

    DataResult<User> save(User user);

    User findByUsername(String username);
}
