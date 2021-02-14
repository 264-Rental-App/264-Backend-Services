package edu.rentals.backend.equipment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.rentals.backend.equipment.entities.Equipment;

@RepositoryRestResource(path = "equipment")
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    public List<Equipment> findByStoreId(Long storeId);
}
