package edu.rentals.backend.stores;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lat", nullable = false)
    private Float lat;

    @Column(name = "lon", nullable = false)
    private Float lon;

    @Column(name = "commonAddress", nullable = false)
    private String commonAddress;

    @Column(name = "category", nullable = false)
    private String category;

    public Store( String name, Float lat, Float lon, Long id, String commonAddress, String category){
        this.id = id;
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
    
    public Store findbylatlon(float lat, float lon, double distance) {
    		double theta = lon - this.lon;
			double dist = Math.sin(Math.toRadians(lat)) * Math.sin(Math.toRadians(this.lat)) + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if(Math.abs(dist) <= distance) {
				return this;	
			}else {
				return null;
			}
    }
}
