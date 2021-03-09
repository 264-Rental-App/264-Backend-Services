package edu.rentals.backend.rental.apis;

import edu.rentals.backend.rental.entities.Equipment;
import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;
import java.util.List;

public class ResponseRental {

    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private Float totalCost;

    @Setter
    @Getter
    private Timestamp transactionDate;

    @Setter
    @Getter
    private Long storeId;

    @Setter
    @Getter
    private String storeName;

    @Setter
    @Getter
    private Timestamp rentalStartDate;

    @Setter
    @Getter
    private Timestamp dueDate;

    @Setter
    @Getter
    private List<Equipment> equipment;

    public ResponseRental() {}
}
