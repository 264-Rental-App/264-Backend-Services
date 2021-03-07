package edu.rentals.backend.invoice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.rentals.backend.invoice.entities.Invoice;

@RepositoryRestResource(path = "invoice")
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    public List<Invoice> findByStoreId(Long storeId);

    public List<Invoice> findByUserId(String userId);
}
