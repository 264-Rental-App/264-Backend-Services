package edu.rentals.backend.forms.api;

import lombok.Setter;

public class PostFormResponse {
    @Setter
    private Long formId;

    public PostFormResponse(Long formId) {
        this.formId = formId;
    }

    public Long getFormId() {
        return this.formId;
    }
}
