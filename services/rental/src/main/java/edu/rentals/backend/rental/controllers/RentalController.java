package edu.rentals.backend.rental.controllers;

import edu.rentals.backend.rental.apis.EquipmentInfo;
import edu.rentals.backend.rental.apis.RentalRequest;
import edu.rentals.backend.rental.entities.Invoice;
import edu.rentals.backend.rental.repositories.EquipmentRepository;
import edu.rentals.backend.rental.repositories.InvoiceRepository;
import edu.rentals.backend.rental.repositories.RentalRepository;
import edu.rentals.backend.rental.entities.Equipment;
import edu.rentals.backend.rental.entities.Rentals;
import edu.rentals.backend.rental.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RentalController {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private StoreRepository storeRepository;

    @PostMapping(value = "/rental", consumes = "application/json", produces = "application/json")
    public Rentals createRental(@RequestBody RentalRequest r) {
        Rentals rentals = new Rentals(r.getStoreId(), r.getUserId(), r.getRentalTime(), r.getReturnTime());
        rentalRepository.save(rentals);

        Double totalCost = 0d;
        for (EquipmentInfo ei : r.getEquipment()) {
            Equipment e = equipmentRepository.findById(ei.getEquipmentId()).get();
            totalCost += e.getPrice();
        }

        String storeName = storeRepository.findById(r.getStoreId()).get().getName();
        Invoice invoice = new Invoice(totalCost, r.getStoreId(), storeName, r.getUserId());
        invoiceRepository.save(invoice);

        return rentals;
    }
}
