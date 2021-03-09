package edu.rentals.backend.rental.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "RENTAL")
public class Rentals {
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
    private String rentalTime;

    @Getter
    @Setter
    @Column(name = "RETURN_TIME", nullable = false)
    private String returnTime;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rental")
    private List<EquipmentInfo> equipment;

    public Rentals(Long storeId, String userId, String rentalTime, String returnTime) {
        this.storeId = storeId;
        this.userId = userId;
        this.rentalTime = rentalTime;
        this.returnTime = returnTime;
    }

    public Rentals() {

    }
}
