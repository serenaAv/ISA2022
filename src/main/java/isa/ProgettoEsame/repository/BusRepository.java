package isa.ProgettoEsame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.ProgettoEsame.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>{

}
