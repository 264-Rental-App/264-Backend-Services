package edu.rentals.backend.equipment.controllers;

import edu.rentals.backend.equipment.entities.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.rentals.backend.equipment.api.PostEquipmentRequest;
import edu.rentals.backend.equipment.api.PostEquipmentResponse;
import edu.rentals.backend.equipment.repositories.EquipmentRepository;

@RestController
public class PostController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @PostMapping(path = "/equipment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostEquipmentResponse newEquipment(@RequestBody PostEquipmentRequest request) {
        Equipment equipment = new Equipment(request.getStoreId(), request.getName(), request.getCategory(),
                request.getCost(), request.getQuantity(), request.getDescription());
        equipmentRepository.save(equipment);

        return new PostEquipmentResponse(equipment.getId());
    }
}
