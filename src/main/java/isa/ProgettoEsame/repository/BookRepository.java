package isa.ProgettoEsame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.ProgettoEsame.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
