package com.techelevator.dao;
import com.techelevator.model.Pothole;

import java.util.List;

public interface PotholeDAO {

    Pothole createPothole(Pothole pothole);

    List<Pothole> getPotholes(Pothole pothole);

    Pothole getOnePothole(Pothole pothole);

}
