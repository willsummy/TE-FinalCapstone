package com.techelevator.dao;
import com.techelevator.model.Service;

import java.util.List;

public interface ServiceDAO {

    void createService (Service service);

    List<Service> getServiceList();

    void reviewServices(Service service);

    void deleteService (long serviceId);

    Service getOneService(Long id);

}
