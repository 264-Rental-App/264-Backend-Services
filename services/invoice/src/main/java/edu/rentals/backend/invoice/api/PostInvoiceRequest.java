package edu.rentals.backend.invoice.api;

import lombok.Getter;
import lombok.Setter;

public class PostInvoiceRequest {
    @Getter
    @Setter
    private Double totalCost;

    @Getter
    @Setter
    private Long storeId;

    @Getter
    @Setter
    private String storeName;

    @Getter
    @Setter
    private String userId;

    public PostInvoiceRequest(Double totalCost, Long storeId, String storeName, String userId) {
        this.totalCost = totalCost;
        this.storeId = storeId;
        this.storeName = storeName;
        this.userId = userId;
    }
}
