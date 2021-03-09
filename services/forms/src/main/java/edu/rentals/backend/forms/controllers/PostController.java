package edu.rentals.backend.forms.controllers;

import edu.rentals.backend.forms.entities.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.rentals.backend.forms.api.PostFormRequest;
import edu.rentals.backend.forms.api.PostFormResponse;
import edu.rentals.backend.forms.repositories.FormRepository;

@RestController
public class PostController {
    @Autowired
    private FormRepository formRepository;

    @PostMapping(path = "/forms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostFormResponse newForm(@RequestBody PostFormRequest request) {
        Form form = new Form(request.getStoreId(), request.getFormBody());
        formRepository.save(form);

        return new PostFormResponse(form.getId());
    }
}
