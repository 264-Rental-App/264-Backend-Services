package edu.rentals.backend.register;

import com.google.firebase.FirebaseApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
        FirebaseApp.initializeApp();
    }
}
