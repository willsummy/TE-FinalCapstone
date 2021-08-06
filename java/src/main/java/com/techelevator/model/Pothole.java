package com.techelevator.model;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;

public class Pothole {


    private long pothole_id;

    private Long user_id;

    private String address;

    private Double latitude;

    private Double longitude;

    private String description;

    private String size;

    private int rank;

    private String dateReported;

    private String timeReported;

    public Long getPothole_id() {
        return pothole_id;
    }

    public void setPothole_id(Long pothole_id) {
        this.pothole_id = pothole_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getDateReported() {
        return dateReported;
    }

    public void setDateReported(String dateReported) {
        this.dateReported = dateReported;
    }

    public String getTimeReported() {
        return timeReported;
    }

    public void setTimeReported(String timeReported) {
        this.timeReported = timeReported;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

