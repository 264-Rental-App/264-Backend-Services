package edu.rentals.backend.forms.controllers;

import java.util.List;

import edu.rentals.backend.forms.entities.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.rentals.backend.forms.api.GetFormsByStoreIdResponse;
import edu.rentals.backend.forms.repositories.FormRepository;

@RestController
public class GetController {
    @Autowired
    private FormRepository formRepository;

    @GetMapping(path = "/rental/forms/{storeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetFormsByStoreIdResponse getFormByStoreId(@PathVariable("storeId") Long storeId) {
        List<Form> forms = formRepository.findByStoreId(storeId);
        return new GetFormsByStoreIdResponse(forms);
    }

    @GetMapping(path = "/rental/forms/{storeId}/{formId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Form getFormByStoreIdAndFormId(@PathVariable("storeId") Long storeId,
            @PathVariable("formId") Long formId) {
        Form form = formRepository.findOneByStoreIdAndId(storeId, formId);
        return form;
    }
}
