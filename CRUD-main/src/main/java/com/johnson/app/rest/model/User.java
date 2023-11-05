package com.johnson.app.rest.model;
import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "comment_from")
    private String commentFrom;

    @Column(name = "comment_to")
    private String commentTo;

    // Getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCommentFrom() {
        return commentFrom;
    }

    public void setCommentFrom(String commentFrom) {
        this.commentFrom = commentFrom;
    }

    public String getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(String commentTo) {
        this.commentTo = commentTo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", commentFrom='" + commentFrom + '\'' +
                ", commentTo='" + commentTo + '\'' +
                '}';
    }
}