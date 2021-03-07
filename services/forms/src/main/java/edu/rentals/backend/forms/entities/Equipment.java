package edu.rentals.backend.forms.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "EQUIPMENT", indexes = { @Index(columnList = "STORE_ID") })
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Getter
    @Column(name = "STORE_ID", nullable = false, updatable = false)
    private Long storeId;

    @Getter
    @Column(name = "EQUIPMENT_NAME", nullable = false)
    private String name;

    @Getter
    @Column(name = "IMG_LOC", nullable = true)
    private String imgLoc;

    @Getter
    @Column(name = "COST")
    private Float price;

    @Getter
    @Column(name = "STOCK")
    private Integer stock;

    @Getter
    @Column(name = "DESCRIPTION")
    private String description;

    public Equipment(Long storeId, String name, String imgLoc, Float cost, Integer stock, String desc) {
        this.storeId = storeId;
        this.name = name;
        this.imgLoc = imgLoc;
        this.price = cost;
        this.stock = stock;
        this.description = desc;
    }

    public Equipment() {
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgLoc(String imgLoc) {
        this.imgLoc = imgLoc;
    }

    public void setCost(Float cost) {
        this.price = cost;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
