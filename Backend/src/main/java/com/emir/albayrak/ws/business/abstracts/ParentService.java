package com.emir.albayrak.ws.business.abstracts;

import com.emir.albayrak.ws.model.Parent;

public interface ParentService {
    Parent save(Parent parent);

    Parent find(int studentId);
}
