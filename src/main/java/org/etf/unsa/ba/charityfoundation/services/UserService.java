package org.etf.unsa.ba.charityfoundation.services;

import org.etf.unsa.ba.charityfoundation.entities.User;

import java.util.List;


public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User save(User users);
    void delete(Long id);

}
