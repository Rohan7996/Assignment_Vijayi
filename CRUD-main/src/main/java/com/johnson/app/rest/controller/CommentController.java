package com.johnson.app.rest.controller;

import com.johnson.app.rest.Service.CommentService;
import com.johnson.app.rest.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestParam String commentFrom,
                                             @RequestParam String commentTo,
                                             @RequestParam String message) {
        try {
            String response = commentService.addComment(commentFrom, commentTo, message);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Comment>> getComments(@RequestParam String commentTo) {
        try {
            List<Comment> comments = commentService.getComments(commentTo);
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
        }
    }
}

