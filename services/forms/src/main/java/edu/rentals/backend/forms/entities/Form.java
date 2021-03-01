package edu.rentals.backend.forms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "FORM", indexes = { @Index(columnList = "STORE_ID") })
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "STORE_ID", nullable = false, updatable = false)
    private Long storeId;

    @Column(name = "CONTENTS", nullable = false)
    private String formBody;

    public Form(Long storeId, String formBody) {
        this.storeId = storeId;
        this.formBody = formBody;
    }

    public Form() {

    }

    public Long getId() {
        return this.id;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public String getFormBody() {
        return this.formBody;
    }
}
