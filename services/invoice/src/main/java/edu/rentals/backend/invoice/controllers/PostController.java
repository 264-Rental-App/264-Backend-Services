package edu.rentals.backend.invoice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.rentals.backend.invoice.api.PostInvoiceRequest;
import edu.rentals.backend.invoice.api.PostInvoiceResponse;
import edu.rentals.backend.invoice.entities.Invoice;
import edu.rentals.backend.invoice.repositories.InvoiceRepository;

@RestController
public class PostController {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @PostMapping(path = "/invoices", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostInvoiceResponse newInvoice(@RequestBody PostInvoiceRequest request) {
        Invoice invoice = new Invoice(request.getTotalCost(), request.getStoreId(), request.getStoreName(),
                request.getUserId());
        invoiceRepository.save(invoice);

        return new PostInvoiceResponse(invoice.getId());
    }
}
