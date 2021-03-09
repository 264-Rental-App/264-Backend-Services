package edu.rentals.backend.equipment.api;

import lombok.Getter;
import lombok.Setter;

public class PatchEquipmentRequest {
    @Getter
    @Setter
    private Long equipmentId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Float cost;

    @Getter
    @Setter
    private String category;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private String description;

    public PatchEquipmentRequest(Long equipmentId, String name, Float cost, String category,
            Integer quantity, String description) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
        this.description = description;
    }
}
