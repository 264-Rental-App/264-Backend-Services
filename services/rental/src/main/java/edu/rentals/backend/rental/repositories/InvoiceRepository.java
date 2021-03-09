package edu.rentals.backend.rental.repositories;

import edu.rentals.backend.rental.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
