package com.techelevator.controller;

import com.techelevator.dao.ServiceDAO;
import com.techelevator.model.Service;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class ServiceController {

    private ServiceDAO serviceDAO;

    public ServiceController(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/service", method = RequestMethod.POST)
    public void createService(@RequestBody Service service) {
        try {
            serviceDAO.createService(service);
        } catch (Exception e) {
            e.printStackTrace();
            }

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/service/{id}/list", method = RequestMethod.GET)
    public Service allServices(@PathVariable Long id) {
        return serviceDAO.getServiceList(id);
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
//    public Service getOneService(@PathVariable Long pothole_id) {
//        return serviceDAO.getOneService(pothole_id);
//    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/service", method = RequestMethod.PUT)
    public void updateService (@RequestBody Service service) {
        serviceDAO.updateService(service);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/service/status", method = RequestMethod.PUT)
    public void setStatus (@RequestBody Service service) {
        serviceDAO.setStatus(service);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/service/{id}", method = RequestMethod.DELETE)
    public void deleteService (@PathVariable Long id) {
        serviceDAO.deleteService(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/service-all/{id}", method = RequestMethod.DELETE)
    public void deleteAllService (@PathVariable Long id) {
        serviceDAO.deleteAllServices(id);
    }


}
