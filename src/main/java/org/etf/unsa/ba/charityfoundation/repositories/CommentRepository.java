package org.etf.unsa.ba.charityfoundation.repositories;

import org.etf.unsa.ba.charityfoundation.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{
}
