package edu.rentals.backend.rental;

import lombok.Getter;
import lombok.Setter;

public class EquipmentInfo {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private int quantity;

    public EquipmentInfo(){}
}
