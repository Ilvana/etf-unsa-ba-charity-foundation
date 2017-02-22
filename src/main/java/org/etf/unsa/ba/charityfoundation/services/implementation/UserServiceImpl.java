package org.etf.unsa.ba.charityfoundation.services.implementation;

import org.etf.unsa.ba.charityfoundation.entities.User;
import org.etf.unsa.ba.charityfoundation.repositories.UserRepository;
import org.etf.unsa.ba.charityfoundation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User users) {
        userRepository.save(users);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
