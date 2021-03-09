package edu.rentals.backend.register.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FORM", indexes = {@Index(columnList = "STORE_ID")})
public class Form {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "STORE_ID", nullable = false, updatable = false)
    private Long storeId;

    @Getter
    @Setter
    @Column(name = "CONTENTS", nullable = false)
    private String formBody;

    public Form(Long storeId, String formBody) {
        this.storeId = storeId;
        this.formBody = formBody;
    }

    public Form() {

    }
}
