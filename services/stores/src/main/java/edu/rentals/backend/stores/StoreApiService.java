package edu.rentals.backend.stores;

import edu.rentals.backend.stores.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StoreApiService extends JpaRepository<Store, Long>, JpaSpecificationExecutor<Store> {
}
