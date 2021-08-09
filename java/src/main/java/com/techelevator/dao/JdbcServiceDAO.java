package com.techelevator.dao;

import com.techelevator.model.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@org.springframework.stereotype.Service
public class JdbcServiceDAO implements ServiceDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcServiceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void setAsInspected(Long id) {

    }

    @Override //why are we using com.techelevator.model.Service service to specify the service?
    public void createService(Service service) {
        String sql = "INSERT INTO service (pothole_id, date_reported, date_inspected, employee_id," +
                " service_status_id, date_repaired,service_description)"
                + " Values (?, CURRENT_DATE, CURRENT_DATE, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Service> getServiceList() {
        return null;
    }

    @Override
    public void updateService(Service service) {

    }

    @Override
    public void deleteService(Long serviceId) {

    }


    @Override
    public Service getOneService(Long id) {
        return null;
    }


    private Service mapRowToService(SqlRowSet rs) {

    Service service = new Service();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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


