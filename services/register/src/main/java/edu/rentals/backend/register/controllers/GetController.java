package edu.rentals.backend.register.controllers;

import edu.rentals.backend.register.api.GetUserByUserIdResponse;
import edu.rentals.backend.register.entities.User;
import edu.rentals.backend.register.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetUserByUserIdResponse getUserByUserId(@PathVariable("userId") String userId) {
        User user = userRepository.findByUserId(userId);
        return new GetUserByUserIdResponse(user);
    }

}
