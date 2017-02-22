package org.etf.unsa.ba.charityfoundation.repositories;

import org.etf.unsa.ba.charityfoundation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
