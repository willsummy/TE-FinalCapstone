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
public class ServiceController {
}
