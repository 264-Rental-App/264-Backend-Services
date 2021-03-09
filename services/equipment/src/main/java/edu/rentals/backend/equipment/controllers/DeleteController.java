package edu.rentals.backend.equipment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.rentals.backend.equipment.repositories.EquipmentRepository;

@RestController
public class DeleteController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @DeleteMapping(path = "/equipment/{equipmentId}")
    public ResponseEntity<?> deleteEquipment(@PathVariable("equipmentId") Long equipmentId) {
        try {
            equipmentRepository.deleteById(equipmentId);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
