package com.isa.ProgettoIsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ProgettoIsa.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer>{

}
