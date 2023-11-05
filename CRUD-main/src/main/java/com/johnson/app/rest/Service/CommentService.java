package com.johnson.app.rest.Service;

import com.johnson.app.rest.Repository.CommentRepository;
import com.johnson.app.rest.Repository.UserRepository;
import com.johnson.app.rest.model.Comment;
import com.johnson.app.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;
    private String message;

    @Transactional
    public String addComment(String commentFrom, String commentTo, String message) {

        // Check if the user exists in the database
        Optional<User> existingUser = userRepository.findByCommentTo(commentTo);

        User fromUser = new User();
        fromUser.setCommentFrom(commentFrom);
        fromUser.setCommentTo(commentTo);

        User toUser = existingUser.orElseGet(() -> {
            // If the user does not exist, create a new user
            User newUser = new User();
            newUser.setCommentFrom(commentFrom);
            newUser.setCommentTo(commentTo);
            userRepository.save(newUser);
            return newUser;
        });

        // Save the fromUser (commenting user) regardless
        userRepository.save(fromUser);
        
        // Create a new comment
        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setCommentDateTime(LocalDateTime.now());
        comment.setPostedByUser(fromUser);

        // Save the comment
        commentRepository.save(comment);

        return "Comment added successfully";
    }

    public List<Comment> getComments(String commentTo) {
        // Find the user
        Optional<User> userOptional = userRepository.findByCommentTo(commentTo);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return commentRepository.findByPostedByUser(commentTo);
        } else {
            // Handle user not found
            return Collections.emptyList();
        }
    }
}

