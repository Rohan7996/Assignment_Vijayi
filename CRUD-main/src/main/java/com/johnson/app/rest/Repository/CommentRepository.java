package com.johnson.app.rest.Repository;

import com.johnson.app.rest.model.Comment;
import com.johnson.app.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostedByUser(User postedByUser);
}
