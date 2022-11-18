package isa.ProgettoEsame.service;

import java.util.List;

import isa.ProgettoEsame.model.Book;

public interface BookService {
    List < Book > getAllBooks();
    List < Book > getAllBooksByUserId(int id);
    void deleteBookById(int id);
    void saveBook(Book book);
    void saveMyBook(Book book);
    Book getBookById(int id);
}