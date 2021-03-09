package edu.rentals.backend.rental.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EQUIPMENT_INFO")
public class EquipmentInfo {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "EQUIPMENT_ID", nullable = false, updatable = false)
    private Long equipmentId;

    @Getter
    @Setter
    @Column(name = "QUANTITY", nullable = false, updatable = false)
    private Integer quantity;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "RENTAL_ID", nullable = false)
    private Rentals rental;

    public EquipmentInfo(Long equipmentId, Integer quantity) {
        this.equipmentId = equipmentId;
        this.quantity = quantity;
    }
}
