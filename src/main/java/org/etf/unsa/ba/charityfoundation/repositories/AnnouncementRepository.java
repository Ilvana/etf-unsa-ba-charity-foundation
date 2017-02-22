package org.etf.unsa.ba.charityfoundation.repositories;

import org.etf.unsa.ba.charityfoundation.entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long>{
}
