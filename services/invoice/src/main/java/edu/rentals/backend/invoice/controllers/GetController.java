package edu.rentals.backend.invoice.controllers;

import java.util.List;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import edu.rentals.backend.invoice.api.GetInvoiceByStoreIdResponse;
import edu.rentals.backend.invoice.entities.Invoice;
import edu.rentals.backend.invoice.repositories.InvoiceRepository;

@RestController
public class GetController {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping(path = "/invoices/{storeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetInvoiceByStoreIdResponse getInvoiceByStoreIdResponse(@PathVariable("storeId") Long storeId) {
        List<Invoice> invoices = invoiceRepository.findOneByStoreId(storeId);
        return new GetInvoiceByStoreIdResponse(invoices);
    }

    @GetMapping(path = "/invoices", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetInvoiceByStoreIdResponse getInvoiceByUser(@RequestHeader("Authorization") String token)
            throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        String uid = decodedToken.getUid();
        return new GetInvoiceByStoreIdResponse(invoiceRepository.findOneByUserId(uid));
    }
}
