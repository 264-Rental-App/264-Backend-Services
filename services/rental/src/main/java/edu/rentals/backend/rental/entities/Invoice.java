package edu.rentals.backend.rental.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "INVOICE", indexes = { @Index(columnList = "STORE_ID,USER_ID") })
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "TOTAL_COST")
    private Double totalCost;

    @Getter
    @Setter
    @Column(name = "TRANSACTION_DATE")
    private String transactionDate;

    @Getter
    @Setter
    @Column(name = "STORE_ID")
    private Long storeId;

    @Getter
    @Setter
    @Column(name = "STORE_NAME")
    private String storeName;

    @Getter
    @Setter
    @Column(name = "USER_ID")
    private String userId;

    @PrePersist
    private void setDate() {
        this.transactionDate = Timestamp.from(Instant.now()).toString();
    }

    public Invoice(Double totalCost, Long storeId, String storeName, String userId) {
        this.totalCost = totalCost;
        this.storeId = storeId;
        this.storeName = storeName;
        this.userId = userId;
    }
}
