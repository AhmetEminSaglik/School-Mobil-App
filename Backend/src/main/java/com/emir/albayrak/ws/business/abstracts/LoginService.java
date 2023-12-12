package com.emir.albayrak.ws.business.abstracts;

import com.emir.albayrak.ws.model.User;
import com.emir.albayrak.ws.model.UserCredentials;

public interface LoginService {
    User findUserByCredentials(UserCredentials userCredentials);
}
