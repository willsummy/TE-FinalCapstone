package com.techelevator.dao;
import com.techelevator.model.Pothole;

import java.util.List;

public interface PotholeDAO {

    void createPothole(Pothole pothole);

    List<Pothole> getPotholesList();

    List<Pothole> getUsersPotholes(Long userId);

    Pothole getOnePothole(Long id);

}
