package edu.rentals.backend.rental.apis;

import lombok.Getter;
import lombok.Setter;

public class EquipmentInfo {
    @Getter
    @Setter
    private Long equipmentId;

    @Getter
    @Setter
    private Integer quantity;

    public EquipmentInfo(Long equipmentId, Integer quantity) {
        this.equipmentId = equipmentId;
        this.quantity = quantity;
    }
}
