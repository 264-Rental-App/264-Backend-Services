package edu.rentals.backend.repositories;

import edu.rentals.backend.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByOwnerId(String ownerId);
}
