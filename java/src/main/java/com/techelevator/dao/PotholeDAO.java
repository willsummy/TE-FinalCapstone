package com.techelevator.dao;
import com.techelevator.model.Pothole;

import java.util.List;

public interface PotholeDAO {

    void createPothole(Pothole pothole);

    List<Pothole> getPotholes();

    Pothole getOnePothole(Long id);

}
