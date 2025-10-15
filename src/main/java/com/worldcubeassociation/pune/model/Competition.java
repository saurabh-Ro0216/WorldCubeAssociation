package com.worldcubeassociation.pune.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Model class representing a WCA Competition
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Competition {

    private String id;
    private String name;

    @JsonProperty("start_date")
    private String date;

    private String city;

    @JsonProperty("base_entry_fee_lowest_denomination")
    private double baseEntryFeeLowestDenomination;

    @JsonProperty("registration_open")
    private String registrationStartDate;

    @JsonProperty("registration_close")
    private String registrationEndDate;

    @JsonProperty("latitude_degrees")
    private Double latitude;

    @JsonProperty("longitude_degrees")
    private Double longitude;

    @JsonProperty("event_ids")
    private String[] eventIds;

    // Constructors
    public Competition() {
    }

    public Competition(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegistrationStartDate() {
        return registrationStartDate;
    }

    public void setRegistrationStartDate(String registrationStartDate) {
        this.registrationStartDate = registrationStartDate;
    }

    public String getRegistrationEndDate() {
        return registrationEndDate;
    }

    public void setRegistrationEndDate(String registrationEndDate) {
        this.registrationEndDate = registrationEndDate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
