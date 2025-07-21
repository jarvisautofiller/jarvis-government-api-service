package com.example.jarvis.controller;

import com.example.jarvis.model.IdRequest;
import com.example.jarvis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GovernmentIdController {

    private final UserService userService;

    @Autowired
    public GovernmentIdController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/userDetails")
    public ResponseEntity<?> getUserByIdAndType(@RequestBody IdRequest request) {
        try {
            Object result = userService.getUserDataByIdAndType(request.getIdNumber(), request.getIdType());
            if (result == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No user with that ID:"+request.getIdNumber());
            }
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

