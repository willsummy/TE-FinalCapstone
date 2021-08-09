package com.techelevator.controller;

import com.techelevator.dao.ServiceDAO;
import com.techelevator.model.Pothole;
import com.techelevator.model.Service;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

//    @RequestMapping(value = "/pothole", method = RequestMethod.GET)
//    public List<Pothole> allPotholes() {
//        return potholeDAO.getPotholesList();
//    }
//
//    @RequestMapping(value = "/pothole", method = RequestMethod.PUT)
//    public void reviewUserPothole(@RequestBody Pothole pothole) {
//        potholeDAO.reviewPotholes(pothole);
//    }
//
//
//
////    @PreAuthorize("hasRole('USER')")
////    @ResponseStatus(HttpStatus.CREATED)
////    @RequestMapping(value = "/pothole", method = RequestMethod.GET)
////    public List<Pothole> getUsersPotholes( Principal principal) {
////
////        return potholeDAO.getPotholesList(userIdList);
////    }
//
//
//    @RequestMapping(value = "/pothole/{id}", method = RequestMethod.DELETE)
//    public void deletePothole (@PathVariable Long id) {
//        potholeDAO.deletePothole(id);
//    }
//

}
