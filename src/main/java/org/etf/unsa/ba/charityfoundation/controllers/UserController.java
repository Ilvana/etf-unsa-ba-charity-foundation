package org.etf.unsa.ba.charityfoundation.controllers;

import org.etf.unsa.ba.charityfoundation.entities.Comment;
import org.etf.unsa.ba.charityfoundation.entities.User;
import org.etf.unsa.ba.charityfoundation.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        try {
            List<User> users = userService.findAll();
            LOGGER.info(String.format("Successfully pulled all users."));
            return new ResponseEntity(users, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Failed pulling all users."));
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            LOGGER.info("Successfully pulled user with id" + id.toString());
            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed pulling user with id " + id.toString());
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody User user) {
        try {
            user.setRole("ROLE_USER");
            user.setEnabled(1);
            user.setRegistered(1);
            user.setComments(new ArrayList<Comment>());
            userService.save(user);
            LOGGER.info(String.format("Successfully registered user."));
            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Failed during registration of user."));
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody User user) {
        try {
            user.setRole("ROLE_USER");
            user.setEnabled(1);
            user.setRegistered(0);
            user.setComments(new ArrayList<Comment>());
            userService.save(user);
            LOGGER.info(String.format("Successfully saved user."));
            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Failed during saving user."));
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long id, @RequestBody User newUser) {
        try {
            User user = userService.findById(id);
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setEnabled(newUser.getEnabled());
            user.setTelephone(newUser.getTelephone());
            user.setRole(newUser.getRole());
            user.setEmail(newUser.getEmail());
            userService.save(user);
            LOGGER.info("Successfully updated user with id:" + id.toString());
            return new ResponseEntity(newUser, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed during updating user with id:" + id.toString());
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            userService.delete(id);
            LOGGER.info("Successfully deleted user with id " + id.toString());
            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed during deleting user with id " + id.toString());
            return new ResponseEntity(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
