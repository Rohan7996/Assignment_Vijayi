package com.johnson.app.rest.Repository;

import com.johnson.app.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCommentTo(String commentTo);
}