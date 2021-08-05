package com.techelevator.dao;

import com.techelevator.model.Pothole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class JdbcServiceDAO implements ServiceDAO {


    @Override
    public void createService(com.techelevator.model.Service service) {
        
    }

    @Override
    public List<com.techelevator.model.Service> getServiceList() {
        return null;
    }

    @Override
    public void reviewServices(com.techelevator.model.Service service) {

    }

    @Override
    public void deleteService(long serviceId) {

    }

    @Override
    public com.techelevator.model.Service getOneService(Long id) {
        return null;
    }
}
