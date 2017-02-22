package org.etf.unsa.ba.charityfoundation.controllers;

import org.etf.unsa.ba.charityfoundation.entities.Comment;
import org.etf.unsa.ba.charityfoundation.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        try {
            List<Comment> comments = commentService.findAll();
            LOGGER.info("Successfully pulled all comments.");
            return new ResponseEntity(comments, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed during pulling all comments");
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            Comment comment = commentService.findById(id);
            LOGGER.info("Successfully pulled comment with id" + id.toString());
            return new ResponseEntity(comment, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed pulling comment with id " + id.toString());
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Comment comment) {
        try {
            commentService.save(comment);
            LOGGER.info(String.format("Successfully saved comment."));
            return new ResponseEntity(comment, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Failed during saving comment."));
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            Comment comment = commentService.findById(id);
            commentService.delete(id);
            LOGGER.info("Successfully deleted comment with id " + id.toString());
            return new ResponseEntity(comment, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed during deleting comment with id " + id.toString());
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
