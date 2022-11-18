package isa.ProgettoEsame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.ProgettoEsame.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    List <Book> findAllBooksByUserId(int id);
}
