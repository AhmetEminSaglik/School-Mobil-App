package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Parent;

import java.util.List;

public interface ParentService {
    Parent save(Parent parent);

    Parent findById(int parentId);
    List<Parent> findAll();
}
