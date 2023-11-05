package com.johnson.app.rest.Repository;

import com.johnson.app.rest.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, BigInteger> {
    List<Comment> findByPostedByUser(String commentTo);
}
