package com.emir.albayrak.ws.dataaccess;

import com.emir.albayrak.ws.business.abstracts.ParentService;
import com.emir.albayrak.ws.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
    Parent save(Parent parent);

    Parent findById(int id);
}
