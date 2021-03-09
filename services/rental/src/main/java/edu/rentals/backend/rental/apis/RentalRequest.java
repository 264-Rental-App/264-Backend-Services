package edu.rentals.backend.rental.apis;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class RentalRequest {
    @Getter
    @Setter
    private Long storeId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String rentalTime;

    @Getter
    @Setter
    private String returnTime;

    @Getter
    @Setter
    private List<EquipmentInfo> equipment;

    public RentalRequest(Long storeId, String userId, String rentalTime, String returnTime, List<EquipmentInfo> equipment) {
        this.storeId = storeId;
        this.userId = userId;
        this.rentalTime = rentalTime;
        this.returnTime = returnTime;
        this.equipment = equipment;
    }
}
