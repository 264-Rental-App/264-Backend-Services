package edu.rentals.backend.equipment.api;

import edu.rentals.backend.equipment.entities.Equipment;
import lombok.Getter;
import lombok.Setter;

public class GetEquipmentResponse {
    @Getter
    @Setter
    private Equipment equipment;

    public GetEquipmentResponse(Equipment equipment) {
        this.equipment = equipment;
    }
}
