package edu.rentals.backend.rental;

import edu.rentals.backend.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RentalApiService extends JpaRepository<Rental, Long>, JpaSpecificationExecutor<Rental> {

    Rental findByinvoiceId(Long InvoiceId);

}
