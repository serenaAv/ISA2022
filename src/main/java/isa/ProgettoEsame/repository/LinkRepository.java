package isa.ProgettoEsame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import isa.ProgettoEsame.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer>{
    
}
