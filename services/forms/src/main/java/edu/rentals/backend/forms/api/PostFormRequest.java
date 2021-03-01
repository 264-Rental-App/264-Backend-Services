package edu.rentals.backend.forms.api;

import lombok.Setter;

public class PostFormRequest {
    @Setter
    private Long storeId;

    @Setter
    private String formBody;

    public PostFormRequest(Long storeId, String formBody) {
        this.storeId = storeId;
        this.formBody = formBody;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public String getFormBody() {
        return this.formBody;
    }
}
