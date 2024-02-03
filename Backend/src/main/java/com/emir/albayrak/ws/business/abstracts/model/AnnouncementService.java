package com.emir.albayrak.ws.business.abstracts.model;

import com.emir.albayrak.ws.model.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> findAll();

    Announcement save(Announcement announcement);
}
