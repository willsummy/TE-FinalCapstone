package com.techelevator.dao;
import com.techelevator.model.Service;

import java.util.List;

public interface ServiceDAO {

    void setStatus(Service service);

    void createService (Service service);

    Service getServiceList(Long id);

    void updateService(Service service);

    void deleteService (Long serviceId);

    void deleteAllServices(Long potholeId);


}
