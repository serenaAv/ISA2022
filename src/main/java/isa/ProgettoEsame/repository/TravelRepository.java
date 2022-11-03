package isa.ProgettoEsame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import isa.ProgettoEsame.model.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer>{
    
}
