package com.techelevator.dao;
import com.techelevator.model.Service;

import java.util.List;

public interface ServiceDAO {

    void setAsInspected(Long id);

    void createService (Service service);

    List<Service> getServiceList();

    void updateService(Service service);

    void deleteService (Long serviceId);

    void deleteAllServices(Long potholeId);

    Service getOneService(Long id);

}
