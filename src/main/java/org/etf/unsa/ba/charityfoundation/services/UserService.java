package org.etf.unsa.ba.charityfoundation.services;

import org.etf.unsa.ba.charityfoundation.entities.User;

import java.util.List;


public interface UserService {
    void save(User users);
    User findById(Long id);
    List<User> findAll();

}
