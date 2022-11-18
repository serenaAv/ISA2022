package isa.ProgettoEsame.service;

import java.time.LocalDate;
import java.util.List;

import isa.ProgettoEsame.model.Travel;

public interface TravelService {
    List < Travel > getAllTravels();
    List < Travel > getAllTravelByDateGreaterThanEqual(LocalDate date);
    void saveTravel(Travel travel);
    Travel getTravelById(int id);
    void deleteTravelById(int id);
}
