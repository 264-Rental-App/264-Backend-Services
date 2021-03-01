package edu.rentals.backend.forms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.rentals.backend.forms.entities.Form;

@RepositoryRestResource(path = "forms")
public interface FormRepository extends JpaRepository<Form, Long> {
    public List<Form> findByStoreId(Long storeId);
    public Form findOneByStoreIdAndId(Long storeId, Long id);
}
