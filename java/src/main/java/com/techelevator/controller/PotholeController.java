package com.techelevator.controller;


import com.techelevator.dao.PotholeDAO;
import com.techelevator.model.Pothole;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PotholeController {

    private PotholeDAO potholeDAO;

    public PotholeController(PotholeDAO potholeDAO) {
        this.potholeDAO = potholeDAO;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/pothole", method = RequestMethod.POST)
    public void createPothole(@RequestBody Pothole pothole) {
        try {
            potholeDAO.createPothole(pothole);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/pothole", method = RequestMethod.GET)
    public List<Pothole> allPotholes() {
        return potholeDAO.getPotholesList();
    }

    @RequestMapping(value = "/pothole", method = RequestMethod.PUT)
    public void reviewUserPothole(@RequestBody Pothole pothole) {
        potholeDAO.reviewPotholes(pothole);
    }



//    @PreAuthorize("hasRole('USER')")
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(value = "/pothole", method = RequestMethod.GET)
//    public List<Pothole> getUsersPotholes( Principal principal) {
//
//        return potholeDAO.getPotholesList(userIdList);
//    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/pothole/{id}", method = RequestMethod.DELETE)
    public void deletePothole (@PathVariable Long id) {
        potholeDAO.deletePothole(id);
    }


}
