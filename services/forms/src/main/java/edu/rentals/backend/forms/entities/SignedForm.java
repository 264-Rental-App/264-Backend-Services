package edu.rentals.backend.forms.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SIGNED_FORM", indexes = {@Index(columnList = "FORM_ID"), @Index(columnList = "USER_ID")})
public class SignedForm {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "FORM_ID", nullable = false, updatable = false)
    private Long formId;

    @Getter
    @Setter
    @Column(name = "USER_ID", nullable = false, updatable = false)
    private String userId;

    @Getter
    @Setter
    @Column(name = "TIMESTAMP", nullable = false)
    private String timestamp;

    @PrePersist
    public void addTimestamp() {
        this.timestamp = (new Timestamp(System.currentTimeMillis())).toString();
    }

    public SignedForm(Long formId, String userId) {
        this.formId = formId;
        this.userId = userId;
    }

    public SignedForm() {

    }
}
