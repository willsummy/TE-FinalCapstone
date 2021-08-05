package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class Service {


    private Long service_id;
    private Long pothole_id;
    private String date_reported;
    private String date_inspected;
    private Long employee_id;
    private Long service_status_id;

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public Long getPothole_id() {
        return pothole_id;
    }

    public void setPothole_id(Long pothole_id) {
        this.pothole_id = pothole_id;
    }

    public String getDate_reported() {
        return date_reported;
    }

    public void setDate_reported(String date_reported) {
        this.date_reported = date_reported;
    }

    public String getDate_inspected() {
        return date_inspected;
    }

    public void setDate_inspected(String date_inspected) {
        this.date_inspected = date_inspected;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getService_status_id() {
        return service_status_id;
    }

    public void setService_status_id(Long service_status_id) {
        this.service_status_id = service_status_id;
    }

    public String getRepaired_date() {
        return repaired_date;
    }

    public void setRepaired_date(String repaired_date) {
        this.repaired_date = repaired_date;
    }

    private String repaired_date;




}
