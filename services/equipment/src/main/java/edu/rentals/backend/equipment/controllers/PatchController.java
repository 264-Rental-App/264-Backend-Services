package edu.rentals.backend.equipment.controllers;

import edu.rentals.backend.equipment.entities.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.rentals.backend.equipment.api.PatchEquipmentRequest;
import edu.rentals.backend.equipment.api.PostEquipmentResponse;
import edu.rentals.backend.equipment.repositories.EquipmentRepository;

@RestController
public class PatchController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @PostMapping(path = "/equipment/{equipmentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostEquipmentResponse newEquipment(@RequestBody PatchEquipmentRequest request) {
        Equipment equipment = equipmentRepository.getOne(request.getEquipmentId());
        if (request.getCost() != null)
            equipment.setPrice(request.getCost());
        if (request.getDescription() != null)
            equipment.setDescription(request.getDescription());
        if (request.getCategory() != null)
            equipment.setCategory(request.getCategory());
        if (request.getName() != null)
            equipment.setName(request.getName());
        if (request.getQuantity() != null)
            equipment.setStock(request.getQuantity());

        equipmentRepository.save(equipment);

        return new PostEquipmentResponse(equipment.getId());
    }

}
