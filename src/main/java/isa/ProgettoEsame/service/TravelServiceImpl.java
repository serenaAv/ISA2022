package isa.ProgettoEsame.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import isa.ProgettoEsame.model.Travel;
import isa.ProgettoEsame.repository.TravelRepository;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public List < Travel > getAllTravels() {
        return travelRepository.findAll();
    }

    @Override
    public void deleteTravelById(int id) {
        this.travelRepository.deleteById(id);
    }

    @Override
    public void saveTravel(Travel travel) {
        this.travelRepository.save(travel);
    }

    @Override
    public Travel getTravelById(int id) {
        Optional < Travel > optional = travelRepository.findById(id);
        Travel travel = null;
        if (optional.isPresent()) {
            travel = optional.get();
        } else {
            throw new RuntimeException(" Travel not found for id :: " + id);
        }
        return travel;
    }

    @Override
    public List <Travel> getAllTravelByDateGreaterThanEqual (LocalDate date)
    {
        return travelRepository.findByDateGreaterThanEqual(date);
    }

}

