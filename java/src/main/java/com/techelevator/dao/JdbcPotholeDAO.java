package com.techelevator.dao;


import com.techelevator.model.Pothole;
import org.springframework.beans.factory.annotation.Autowired;
import com.techelevator.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class JdbcPotholeDAO implements PotholeDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPotholeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPothole(Pothole pothole) {
        String sql = "INSERT INTO potholes (user_id, date_reported, time_reported, address," +
                " latitude, longitude, description, size)"
                + " Values (?, CURRENT_DATE, CURRENT_TIME, ?, ?, ?, ?, ?)";
       jdbcTemplate.update(sql, pothole.getUser_id(), pothole.getAddress(), pothole.getLatitude(),
               pothole.getLongitude(), pothole.getDescription(), pothole.getSize());
    }


    @Override //inserting pothole object into pothole table
    public List<Pothole> getPotholesList() {
        List<Pothole> allPotholesList = new ArrayList<>();
        String sql = "SELECT * FROM potholes";
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Pothole allPotholes = mapRowToPothole(results);
            allPotholesList.add(allPotholes);
        }
        return allPotholesList;
    }

    @Override
    public List<Pothole> getUsersPotholes(Long userId) {
        List<Pothole> allPotholesList = new ArrayList<>();
        String sql = "SELECT * FROM potholes WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Pothole allPotholes = mapRowToPothole(results);
            allPotholesList.add(allPotholes);
        }
        return allPotholesList;
    }

    @Override
    public Pothole getOnePothole(Long id) {
        return null;
    }


    private Pothole mapRowToPothole(SqlRowSet rs) {
        Pothole pothole = new Pothole();
        //pothole.setPotholeId(rs.getLong("pothole_id"));
        pothole.setUser_id(rs.getLong("user_id"));
        //pothole.setDateReported(rs.getString("date_reported"));
        //pothole.setTimeReported(rs.getString("time_reported"));
        pothole.setAddress(rs.getString("address"));
        pothole.setLatitude(rs.getDouble("latitude"));
        pothole.setLongitude(rs.getDouble("longitude"));
        pothole.setDescription(rs.getString("description"));
        pothole.setSize(rs.getString("size"));
        pothole.setRank(rs.getInt("rank"));
            return pothole;
    }


}
