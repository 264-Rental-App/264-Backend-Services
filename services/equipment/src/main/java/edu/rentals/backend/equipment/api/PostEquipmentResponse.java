package edu.rentals.backend.equipment.api;

import lombok.Getter;
import lombok.Setter;

public class PostEquipmentResponse {
    @Getter
    @Setter
    private Long equipmentId;

    public PostEquipmentResponse(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
}
