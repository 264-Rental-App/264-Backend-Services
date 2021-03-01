package edu.rentals.backend.forms.api;

import java.util.List;

import edu.rentals.backend.forms.entities.Form;
import lombok.Getter;
import lombok.Setter;

public class GetFormsByStoreIdResponse {
    @Getter
    @Setter
    private List<Form> forms;

    public GetFormsByStoreIdResponse(List<Form> forms) {
        this.forms = forms;
    }
}
