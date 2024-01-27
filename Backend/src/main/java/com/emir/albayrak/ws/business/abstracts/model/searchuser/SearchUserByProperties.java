package com.emir.albayrak.ws.business.abstracts.model.searchuser;

import com.emir.albayrak.ws.model.User;

import java.util.List;

public interface SearchUserByProperties<T extends User> {
    List<T> searchByName(String name);

    List<T> searchByLastName(String name);
}
