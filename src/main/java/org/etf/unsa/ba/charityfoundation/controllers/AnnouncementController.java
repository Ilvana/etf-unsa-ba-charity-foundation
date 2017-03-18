package org.etf.unsa.ba.charityfoundation.controllers;

import org.etf.unsa.ba.charityfoundation.entities.Announcement;
import org.etf.unsa.ba.charityfoundation.entities.Comment;
import org.etf.unsa.ba.charityfoundation.services.AnnouncementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/announcement")
public class AnnouncementController {

    public static Logger LOGGER = LoggerFactory.getLogger(Announcement.class);
    @Autowired
    AnnouncementService announcementService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        try {
            List<Announcement> announcements = announcementService.findAll();
            LOGGER.info("Successfully pulled all announcements.");
            return new ResponseEntity(announcements, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed during pulling all announcements");
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            Announcement announcement = announcementService.findById(id);
            LOGGER.info("Successfully pulled announcement with id" + id.toString());
            return new ResponseEntity(announcement, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed pulling announcement with id " + id.toString());
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Announcement announcement) {
        try {
            announcement.setComments(new ArrayList<Comment>());
            announcementService.save(announcement);
            LOGGER.info(String.format("Successfully saved announcement."));
            return new ResponseEntity(announcement, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Failed during saving announcement."));
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long id, @RequestBody Announcement newAnnouncement) {
        try {
            Announcement announcement = announcementService.findById(id);
            announcement.setText(newAnnouncement.getText());
            announcement.setDate(newAnnouncement.getDate());
            announcement.setAccount(newAnnouncement.getAccount());
            announcement.setPicture(newAnnouncement.getPicture());
            announcement.setTelephone(newAnnouncement.getTelephone());

            announcementService.save(announcement);
            LOGGER.info("Successfully updated announcement with id:" + id.toString());
            return new ResponseEntity(newAnnouncement, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed during updating announcement with id:" + id.toString());
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            Announcement announcement = announcementService.findById(id);
            announcementService.delete(id);
            LOGGER.info("Successfully deleted announcement with id " + id.toString());
            return new ResponseEntity(announcement, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed during deleting announcement with id " + id.toString());
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
