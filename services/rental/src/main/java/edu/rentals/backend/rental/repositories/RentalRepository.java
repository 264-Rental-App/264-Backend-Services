package edu.rentals.backend.rental.repositories;

import edu.rentals.backend.rental.entities.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RentalRepository extends JpaRepository<Rentals, Long>, JpaSpecificationExecutor<Rentals> {
}
