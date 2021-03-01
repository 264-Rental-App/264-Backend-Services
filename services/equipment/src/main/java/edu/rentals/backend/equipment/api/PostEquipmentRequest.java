package edu.rentals.backend.equipment.api;

import lombok.Setter;

public class PostEquipmentRequest {
    @Setter
    private Long storeId;

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

    public PostEquipmentRequest(Long storeId, String name, Float cost, String imgLoc, Integer quantity,
            String description) {
        this.storeId = storeId;
        this.name = name;
        this.cost = cost;
        this.imgLoc = imgLoc;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getStoreId() {
        return this.storeId;
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
