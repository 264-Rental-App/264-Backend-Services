package edu.rentals.backend.invoice.entities;

import javax.persistence.*;

@Entity
@Table(name = "STORES")
public class Store {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LAT", nullable = false)
    private Float lat;

    @Column(name = "LONG", nullable = false)
    private Float lon;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "COMMON_ADDRESS", nullable = false)
    private String commonAddress;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    public Store(String name, Float lat, Float lon, String commonAddress, String category) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.commonAddress = commonAddress;
        this.category = category;
    }

    public Store() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
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
        double dist = Math.sin(Math.toRadians(lat)) * Math.sin(Math.toRadians(this.lat)) + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        return dist;
    }

}
