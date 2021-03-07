package edu.rentals.backend.invoice.api;

import lombok.Getter;
import lombok.Setter;

public class PostInvoiceResponse {
    @Getter
    @Setter
    private Long invoiceId;

    public PostInvoiceResponse(Long invoiceId) {
        this.invoiceId = invoiceId;
    }
}
