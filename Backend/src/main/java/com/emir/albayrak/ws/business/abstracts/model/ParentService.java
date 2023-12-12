package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Parent;

public interface ParentService {
    Parent save(Parent parent);

    Parent findByStudentId(int studentId);
}
