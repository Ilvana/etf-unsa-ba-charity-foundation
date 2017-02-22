package org.etf.unsa.ba.charityfoundation.services.implementation;

import org.etf.unsa.ba.charityfoundation.entities.Announcement;
import org.etf.unsa.ba.charityfoundation.repositories.AnnouncementRepository;
import org.etf.unsa.ba.charityfoundation.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    AnnouncementRepository announcementsRepository;

    @Override
    public List<Announcement> findAll() {
        return announcementsRepository.findAll();
    }

    @Override
    public Announcement findById(Long id) {
        return announcementsRepository.findOne(id);
    }

    @Override
    public void save(Announcement announcements) {
        announcementsRepository.save(announcements);
    }
}
