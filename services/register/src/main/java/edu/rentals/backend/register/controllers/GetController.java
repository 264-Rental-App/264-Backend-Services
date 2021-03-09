package edu.rentals.backend.register.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import edu.rentals.backend.register.api.GetUserInfo;
import edu.rentals.backend.register.entities.User;
import edu.rentals.backend.register.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetUserInfo getUserByUserId(@RequestHeader("Authorization") String token, @PathVariable("userId") String userId) throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        String uid = decodedToken.getUid();
        User user = userRepository.findOneByUserId(userId);
        return new GetUserInfo(user.getUserFirstName(), user.getUserType());
    }
}
