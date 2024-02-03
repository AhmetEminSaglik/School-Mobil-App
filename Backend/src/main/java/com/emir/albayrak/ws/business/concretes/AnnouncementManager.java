package com.emir.albayrak.ws.business.concretes;

import com.emir.albayrak.ws.business.abstracts.model.AnnouncementService;
import com.emir.albayrak.ws.dataaccess.AnnouncementRepository;
import com.emir.albayrak.ws.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementManager implements AnnouncementService {
    AnnouncementRepository rep;

    @Autowired
    public AnnouncementManager(AnnouncementRepository rep) {
        this.rep = rep;
    }

    @Override
    public List<Announcement> findAll() {
        return rep.findAll();
    }

    @Override
    public Announcement save(Announcement announcement) {
        return rep.save(announcement);
    }
}
