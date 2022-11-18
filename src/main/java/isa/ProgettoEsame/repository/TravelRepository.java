package isa.ProgettoEsame.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import isa.ProgettoEsame.model.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer>{

    List<Travel> findByDateGreaterThanEqual(LocalDate date);

}
