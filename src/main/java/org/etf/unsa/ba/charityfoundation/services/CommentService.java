package org.etf.unsa.ba.charityfoundation.services;

import org.etf.unsa.ba.charityfoundation.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment findById(Long id);
    void save(Comment comment);
}
