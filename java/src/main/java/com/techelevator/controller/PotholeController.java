package com.techelevator.controller;


import com.techelevator.dao.PotholeDAO;
import com.techelevator.model.Pothole;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
public class PotholeController {

    private PotholeDAO potholeDAO;

    public PotholeController(PotholeDAO potholeDAO) {
        this.potholeDAO = potholeDAO;
    }

    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/pothole", method = RequestMethod.POST)
    public void createPothole(@RequestBody Pothole pothole) {
        potholeDAO.createPothole(pothole);
    }

}
