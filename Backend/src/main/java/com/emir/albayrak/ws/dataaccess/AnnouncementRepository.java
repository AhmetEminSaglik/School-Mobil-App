package com.emir.albayrak.ws.dataaccess;

import com.emir.albayrak.ws.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
}
