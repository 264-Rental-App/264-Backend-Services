package edu.rentals.backend.register.controllers;

import edu.rentals.backend.register.api.PostNewUserRequest;
import edu.rentals.backend.register.api.PostNewUserResponse;
import edu.rentals.backend.register.entities.User;
import edu.rentals.backend.register.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostNewUserResponse newUser(@RequestBody PostNewUserRequest request) {
        User user = new User(request.getUserId(), request.getUserFirstName(), request.getUserEmail(), request.getUserPhoneNumber());
        userRepository.save(user);

        return new PostNewUserResponse(user.getUserId());
    }
}
