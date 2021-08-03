package com.techelevator.dao;


import com.techelevator.model.Pothole;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcPotholeDAO implements PotholeDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPotholeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pothole createPothole(Pothole pothole) {
        String sql = "INSERT INTO pothole (user_id, date_reported, time_reported) "
                + "Values (?, ?, ?) returning pothole_id";
        Pothole createdPothole = jdbcTemplate.queryForObject(sql, Pothole.class, pothole.getUserId(),
                pothole.getDateReported(), pothole.getTimeReported());
        return createdPothole;
    }


    @Override //inserting pothole object into pothole table
    public List<Pothole> getPotholes(Pothole pothole) {
        return null;
    }

    @Override
    public Pothole getOnePothole(Pothole pothole) {
        return null;
    }


    private Pothole mapRowToTransfer(SqlRowSet rs) {
        Pothole pothole = new Pothole();
        pothole.setPotholeId(rs.getInt("pothole_id"));
        pothole.setUserId(rs.getInt("user_id"));
        pothole.setDateReported(rs.getString("date_reported"));
        pothole.setTimeReported(rs.getString("time_reported"));
        return pothole;
    }


}
