package edu.rentals.backend.store;

import edu.rentals.backend.stores.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface StoreApiService extends JpaRepository<Store, Long> {
    Store findByOwnerId(String ownerId);
}
