package com.techelevator.model;
import javax.validation.constraints.NotEmpty;

public class Pothole {

    private long potholeId;
    @NotEmpty
    private long userId;
    @NotEmpty
    private String dateReported;
    @NotEmpty
    private String timeReported;


    public long getPotholeId() {
        return potholeId;
    }

    public void setPotholeId(int potholeId) {
        this.potholeId = potholeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
