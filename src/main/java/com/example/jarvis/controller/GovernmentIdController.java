package com.example.jarvis.controller;

import com.example.jarvis.model.IdRequest;
import com.example.jarvis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/")
public class GovernmentIdController {

    private final UserService userService;

    @Autowired
    public GovernmentIdController(UserService userService) {
        this.userService = userService;
    }


    @Operation(summary = "Get user details by ID and type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json"))
    })
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

