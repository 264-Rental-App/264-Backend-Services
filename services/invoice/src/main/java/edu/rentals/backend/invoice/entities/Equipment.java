package edu.rentals.backend.invoice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EQUIPMENT", indexes = {@Index(columnList = "STORE_ID")})
public class Equipment {
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
    @Column(name = "EQUIPMENT_NAME", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "CATEGORY", nullable = true)
    private String category;

    @Getter
    @Setter
    @Column(name = "COST")
    private Float price;

    @Getter
    @Setter
    @Column(name = "STOCK")
    private Integer stock;

    @Getter
    @Setter
    @Column(name = "DESCRIPTION")
    private String description;

    public Equipment(Long storeId, String name, String category, Float cost, Integer stock, String desc) {
        this.storeId = storeId;
        this.name = name;
        this.category = category;
        this.price = cost;
        this.stock = stock;
        this.description = desc;
    }

    public Equipment() {
    }
}
