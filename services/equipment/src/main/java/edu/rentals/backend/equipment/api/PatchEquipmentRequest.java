package edu.rentals.backend.equipment.api;

import lombok.Setter;

public class PatchEquipmentRequest {
    @Setter
    private Long equipmentId;

    @Setter
    private String name;

    @Setter
    private Float cost;

    @Setter
    private String imgLoc;

    @Setter
    private Integer quantity;

    @Setter
    private String description;

    public PatchEquipmentRequest(Long equipmentId, String name, Float cost, String imgLoc,
            Integer quantity, String description) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.cost = cost;
        this.imgLoc = imgLoc;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getEquipmentId() {
        return this.equipmentId;
    }

    public String getName() {
        return this.name;
    }

    public Float getCost() {
        return this.cost;
    }

    public String getImgLoc() {
        return this.imgLoc;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public String getDescription() {
        return this.description;
    }
}
