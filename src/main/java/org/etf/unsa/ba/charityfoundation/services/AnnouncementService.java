package org.etf.unsa.ba.charityfoundation.services;

import org.etf.unsa.ba.charityfoundation.entities.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> findAll();
    Announcement findById(Long id);
    void save(Announcement announcements);
}
