package edu.rentals.backend.rental.repositories;

import edu.rentals.backend.rental.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
