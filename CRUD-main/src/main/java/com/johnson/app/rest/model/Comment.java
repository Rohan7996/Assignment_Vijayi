package com.johnson.app.rest.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "message")
    private String message;

    @Column(name = "comment_date_time")
    private LocalDateTime commentDateTime;

    @ManyToOne
    @JoinColumn(name = "posted_by_user_id")
    private User postedByUser;

    // Getters and setters

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCommentDateTime() {
        return commentDateTime;
    }

    public void setCommentDateTime(LocalDateTime commentDateTime) {
        this.commentDateTime = commentDateTime;
    }

    public User getPostedByUser() {
        return postedByUser;
    }

    public void setPostedByUser(User postedByUser) {
        this.postedByUser = postedByUser;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", message='" + message + '\'' +
                ", commentDateTime=" + commentDateTime +
                ", postedByUser=" + postedByUser +
                '}';
    }
}