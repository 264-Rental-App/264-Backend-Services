package edu.rentals.backend.invoice;

import com.google.firebase.FirebaseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
		FirebaseApp.initializeApp();
	}

}
