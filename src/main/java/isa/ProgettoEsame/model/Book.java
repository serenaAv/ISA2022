package isa.ProgettoEsame.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_book")
    private String date_book;

    @Column(name = "description")
    private String description;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_book() {
        return date_book;
    }
    public void setTime(String date_book) {
        this.date_book = date_book;
    }

    @ManyToOne
    @JoinColumn(name="id_trav")
    private Travel travel;
    public Travel getTravel(){
        return travel;
    }
    public void setTravel(Travel travel){
        this.travel = travel;
    }

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

}
