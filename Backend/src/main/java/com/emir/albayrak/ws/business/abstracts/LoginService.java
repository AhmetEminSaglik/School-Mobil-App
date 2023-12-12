package com.emir.albayrak.ws.business.abstracts;

import com.emir.albayrak.ws.model.User;
import com.emir.albayrak.ws.model.LoginCredentials;
import utility.result.DataResult;

public interface LoginService {
    DataResult<User> findUserByLoginCredentials(LoginCredentials loginCredentials);
}
