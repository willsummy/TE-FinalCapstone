package com.techelevator.dao;
import com.techelevator.model.Pothole;

import java.util.List;

public interface PotholeDAO {

    void createPothole(Pothole pothole);

    List<Pothole> getPotholesList();

    List<Pothole> getUsersPotholes(Long userId);

    void reviewPotholes(Pothole pothole);

    void deletePothole(long potholeId);

    Pothole getOnePothole(Long id);
}
