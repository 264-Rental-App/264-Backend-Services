package edu.rentals.backend.rental;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Equipment")
public class Equipment {

    @ManyToOne
    @JoinColumn(name="rentalid", nullable=false)
    private Rental rental;

    @Getter
    @Setter
    private Long equipmentId;

    @Getter
    @Setter
    private int quantity;

    @Id
    private Long id;


    public Equipment(Long equipmentid, int quantity){
        this.equipmentId = equipmentid;
        this.quantity = quantity;
    }

    public Equipment() {

    }

}
