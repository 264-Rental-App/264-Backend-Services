package edu.rentals.backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STORES")
public class Store {

    @Getter
    @Setter
    @Column(name = "NAME", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "LAT", nullable = false)
    private Float lat;

    @Getter
    @Setter
    @Column(name = "LONG", nullable = false)
    private Float lon;

    @Id
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "COMMON_ADDRESS", nullable = false)
    private String commonAddress;

    @Getter
    @Setter
    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Getter
    @Setter
    @Column(name = "OWNER_ID", nullable = false)
    private String ownerId;

    public Store(String name, Float lat, Float lon, String commonAddress, String category, String ownerId) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.commonAddress = commonAddress;
        this.category = category;
        this.ownerId = ownerId;
    }

    public Store() {

    }

    public double findByLatLong(float lat, float lon, double distance) {
        double theta = lon - this.lon;
        double dist = Math.sin(Math.toRadians(lat)) * Math.sin(Math.toRadians(this.lat)) + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        return dist;
    }
}
