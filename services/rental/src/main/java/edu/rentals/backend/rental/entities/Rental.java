package edu.rentals.backend.rental.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "RENTAL")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "STORE_ID", nullable = false)
    private Long storeId;

    @Getter
    @Setter
    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Getter
    @Setter
    @Column(name = "RENTAL_TIME", nullable = false)
    private Timestamp rentalTime;

    @Getter
    @Setter
    @Column(name = "RETURN_TIME", nullable = false)
    private Timestamp returnTime;

    @Getter
    @Setter
    @Column(name = "INVOICE_ID", nullable = false)
    private Long invoiceId;

    @Getter
    @Setter
    @OneToMany(mappedBy = "rental")
    private List<Equipment> equipment;

    public Rental(Long storeId, String userId, Long invoiceId, Timestamp rentalTime, Timestamp returnTime) {
        this.storeId = storeId;
        this.userId = userId;
        this.rentalTime = rentalTime;
        this.returnTime = returnTime;
        this.invoiceId = invoiceId;
    }

    public Rental() {

    }
}
