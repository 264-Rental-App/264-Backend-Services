package edu.rentals.backend.equipment.controllers;

import java.util.List;

import edu.rentals.backend.equipment.entities.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.rentals.backend.equipment.api.GetEquipmentByStoreIdResponse;
import edu.rentals.backend.equipment.api.GetEquipmentResponse;
import edu.rentals.backend.equipment.repositories.EquipmentRepository;

@RestController
public class GetController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping(path = "/equipment/{storeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetEquipmentByStoreIdResponse getEquipmentByStoreId(@PathVariable("storeId") Long storeId) {
        List<Equipment> equipment = equipmentRepository.findByStoreId(storeId);
        return new GetEquipmentByStoreIdResponse(equipment);
    }

    @GetMapping(path = "/equipment/{equipmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetEquipmentResponse getEquipmentById(@PathVariable("equipmentId") Long equipmentId) {
        Equipment equipment = equipmentRepository.getOne(equipmentId);
        return new GetEquipmentResponse(equipment);
    }
}
