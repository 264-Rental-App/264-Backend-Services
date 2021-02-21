package edu.rentals.backend.stores;

import edu.rentals.backend.stores.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreApiService extends JpaRepository<Store, Long>{
}
