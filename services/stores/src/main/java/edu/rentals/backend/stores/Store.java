package edu.rentals.backend.stores;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STORES")
public class Store {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LAT", nullable = false)
    private Double lat;

    @Column(name = "LONG", nullable = false)
    private Double lon;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMMON_ADDRESS", nullable = false)
    private String commonAddress;

    @Getter
    @Setter
    @Column(name = "manager", nullable = false)
    private String ownerId;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Getter
    @Setter
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Store(String name, Double lat, Double lon, String id, String commonAddress, String category,
            String phoneNumber) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommonAddress() {
        return commonAddress;
    }

    public void setCommonAddress(String commonAddress) {
        this.commonAddress = commonAddress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double findByLatLong(float lat, float lon, double distance) {
        double theta = lon - this.lon;
        double dist = Math.sin(Math.toRadians(lat)) * Math.sin(Math.toRadians(this.lat))
                + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        return dist;
    }

}
