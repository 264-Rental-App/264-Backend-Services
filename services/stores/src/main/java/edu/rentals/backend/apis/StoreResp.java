package edu.rentals.backend.apis;

import lombok.Data;

@Data
public class StoreResp {
    private Long storeId;

    private String name;

    private Double lon;

    private Double lat;

    private String ownerId;

    private String category;

    private String phoneNumber;

    private String commonAddress;

}
