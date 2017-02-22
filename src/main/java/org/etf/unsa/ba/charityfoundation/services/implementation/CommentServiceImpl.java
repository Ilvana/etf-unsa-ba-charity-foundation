package org.etf.unsa.ba.charityfoundation.services.implementation;

import org.etf.unsa.ba.charityfoundation.entities.Comment;
import org.etf.unsa.ba.charityfoundation.repositories.CommentRepository;
import org.etf.unsa.ba.charityfoundation.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.delete(id);
    }
}
