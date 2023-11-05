package com.johnson.app.rest.Repository;

import com.johnson.app.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    Optional<User> findByCommentTo(String commentTo);
}