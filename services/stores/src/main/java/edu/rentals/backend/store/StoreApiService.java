package edu.rentals.backend.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StoreApiService extends JpaRepository<Store, Long>, JpaSpecificationExecutor<Store> {
}
