package edu.rentals.backend.invoice.api;

import java.util.List;

import edu.rentals.backend.invoice.entities.Invoice;
import lombok.Getter;
import lombok.Setter;

public class GetInvoiceByStoreIdResponse {
    @Getter
    @Setter
    private List<Invoice> invoices;

    public GetInvoiceByStoreIdResponse(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
