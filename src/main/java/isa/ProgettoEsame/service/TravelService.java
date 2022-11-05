package isa.ProgettoEsame.service;

import java.util.List;

import isa.ProgettoEsame.model.Travel;

public interface TravelService {
    List < Travel > getAllTravels();
    void saveTravel(Travel travel);
    Travel getTravelById(int id);
    void deleteTravelById(int id);
}
