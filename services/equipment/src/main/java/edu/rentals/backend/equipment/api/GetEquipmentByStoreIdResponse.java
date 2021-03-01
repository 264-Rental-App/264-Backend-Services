package edu.rentals.backend.equipment.api;

import java.util.List;

import edu.rentals.backend.equipment.entities.Equipment;
import lombok.Getter;
import lombok.Setter;

public class GetEquipmentByStoreIdResponse {
    @Getter
    @Setter
    private List<Equipment> equipment;

    public GetEquipmentByStoreIdResponse(List<Equipment> equipment) {
        this.equipment = equipment;
    }
}
