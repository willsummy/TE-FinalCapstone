package com.techelevator.dao;

import com.techelevator.model.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class JdbcServiceDAO implements ServiceDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcServiceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void setStatus(Service service) {
       String sql = "UPDATE service SET service_status_id = ? WHERE service_id = ?";
            jdbcTemplate.update(sql, service.getService_status_id(), service.getService_id());
    }


    @Override
    public void createService(Service service) {
        String sql = "INSERT INTO service (pothole_id, date_reported, employee_id, service_status_id)"
                + " Values (?, ?, ?, 1)";
        jdbcTemplate.update(sql, service.getPothole_id(), LocalDate.parse(service.getDate_reported()), service.getEmployee_id());
    }

    @Override
    public List<Service> getServiceList() {
        List<Service> allServicesList = new ArrayList<>();
        String sql = "SELECT service_id, pothole_id, date_reported, date_inspected, date_repaired," +
                "employee_id, service_status_id, service_description FROM service WHERE pothole_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
           Service allServices = mapRowToService(results);
            allServicesList.add(allServices);
        }
        return allServicesList;
    }

    @Override
    public void updateService(Service service) {
        String sql = "UPDATE service SET service_id = ?, pothole_id = ?, date_reported = ?, " +
                "date_inspected = ?, date_repaired = ?, employee_id = ?, " +
                "service_status_id = ?, service_description = ?";
        jdbcTemplate.update(sql, service.getService_id(), service.getPothole_id(),
                service.getDate_reported(), service.getDate_inspected(), service.getDate_repaired(),
                service.getEmployee_id(), service.getService_status_id(), service.getService_description());
    }

    @Override
    public void deleteService(Long serviceId) {
        String sql = "DELETE FROM service WHERE service_id = ?";
        jdbcTemplate.update(sql, serviceId);
    }

    @Override
    public void deleteAllServices(Long potholeId) {
        String sql = "DELETE FROM service WHERE pothole_id = ?";
        jdbcTemplate.update(sql, potholeId);
    }

    private Service mapRowToService(SqlRowSet rs) {

    Service service = new Service();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate dateReported = LocalDate.parse(rs.getDate("date_reported").toString());
    LocalDate inspectedDate = LocalDate.parse(rs.getDate("date_inspected").toString());
    LocalDate repairedDate = LocalDate.parse(rs.getDate("repaired_date").toString());
    String dateReportedText = dateReported.format(dateFormat);
    String dateInspectedText = inspectedDate.format(dateFormat);
    String dateRepairedText = repairedDate.format(dateFormat);

        service.setService_id(rs.getLong("service_id"));
        service.setPothole_id(rs.getLong("pothole_id"));
        service.setEmployee_id(rs.getLong("employee_id"));
        service.setService_status_id(rs.getLong("service_status_id"));
        service.setDate_repaired(dateRepairedText);
        service.setDate_reported(dateReportedText);
        service.setDate_inspected(dateInspectedText);
        service.setService_description(rs.getString("service_description"));
        return service;
    }

}


