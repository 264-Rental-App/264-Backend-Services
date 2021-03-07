package edu.rentals.backend.store;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Stores")
public class Store {

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "lat", nullable = false)
    private Double lat;

    @Getter
    @Setter
    @Column(name = "long", nullable = false)
    private Double lon;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "manager", nullable = false)
    private String ownerId;

    @Getter
    @Setter
    @Column(name = "commonAddress", nullable = false)
    private String commonAddress;

    @Getter
    @Setter
    @Column(name = "category")
    private String category;

    @Getter
    @Setter
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Store(String name, Double lat, Double lon, String id, String commonAddress, String category, String phoneNumber) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.ownerId = id;
        this.commonAddress = commonAddress;
        this.category = category;
        this.phoneNumber = phoneNumber;
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
