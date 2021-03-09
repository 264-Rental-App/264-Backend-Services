package edu.rentals.backend.rental.repositories;

import edu.rentals.backend.rental.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
