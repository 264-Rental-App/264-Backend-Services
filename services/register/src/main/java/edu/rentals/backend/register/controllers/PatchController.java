package edu.rentals.backend.register.controllers;

import edu.rentals.backend.register.api.PatchUserByIdRequest;
import edu.rentals.backend.register.api.PostNewUserResponse;
import edu.rentals.backend.register.entities.User;
import edu.rentals.backend.register.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatchController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/users/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostNewUserResponse updatedUser(@RequestBody PatchUserByIdRequest request) {
        User user = userRepository.findByUserId(request.getUserId());

        if(request.getUserFirstName() != null) {
            user.setUserFirstName(request.getUserFirstName());
        }
        if(request.getUserEmail() != null) {
            user.setUserEmail(request.getUserEmail());
        }
        if(request.getUserPhoneNumber() != null) {
            user.setUserPhoneNumber(request.getUserPhoneNumber());
        }

        userRepository.save(user);

        return new PostNewUserResponse(user.getUserId());
    }

}
