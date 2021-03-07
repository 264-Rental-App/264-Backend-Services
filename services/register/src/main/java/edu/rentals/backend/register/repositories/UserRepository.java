package edu.rentals.backend.register.repositories;

import edu.rentals.backend.register.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, String> {
    public User findOneByUserId(String userID);
}
