package edu.rentals.backend.forms.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "SIGNED_FORM", indexes = { @Index(columnList = "FORM_ID"), @Index(columnList = "USER_ID") })
public class SignedForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "FORM_ID", nullable = false, updatable = false)
    private Long formId;

    @Column(name = "USER_ID", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    @PrePersist
    public void addTimestamp() {
        this.timestamp = (new Timestamp(System.currentTimeMillis())).toString();
    }

    public SignedForm(Long formId, Long userId) {
        this.formId = formId;
        this.userId = userId;
    }

    public SignedForm() {

    }

    public Long getId() {
        return this.id;
    }

    public Long getFormId() {
        return this.formId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getTimestamp() {
        return this.timestamp;
    }
}
