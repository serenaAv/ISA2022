package isa.ProgettoEsame.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "travels")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date_travel")
    private String date_travel;

    @Column(name = "time_dep_real")
    private String time_dep_real;

    @Column(name = "time_arr_real")
    private String time_arr_real;

    @Column(name = "n_pass")
    private Integer n_pass;









    @ManyToOne
    @JoinColumn(name = "id_bus")
    private Bus bus;

    public Bus getBus(){
        return bus;
    }
    public void setBus(Bus bus){
        this.bus = bus;
    }

    @ManyToOne
    @JoinColumn(name="id_link")
    private Link link;
    public Link getLink(){
        return link;
    }
    public void setLink(Link link){
        this.link = link;
    }

    @ManyToMany(mappedBy = "travels")
    private Set<User> users = new HashSet<>();
    public Set<User> getUsers(){
        return users;
    }

    public void setUsers(Set<User> users){
        this.users = users;
    }

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book;
    public List<Book> getBooks(){
        return book;
    }
    public void setBooks(List<Book> books){
        this.book = books;
    }

    




    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate_travel() {
        return date_travel;
    }
    public void setDate_travel(String date_travel) {
        this.date_travel = date_travel;
    }

    public String getTime_dep_real() {
        return time_dep_real;
    }
    public void setTime_dep_real(String time_dep_real) {
        this.time_dep_real = time_dep_real;
    }

    public String getTime_arr_real() {
        return time_arr_real;
    }
    public void setTime_arr_real(String time_arr_real) {
        this.time_arr_real = time_arr_real;
    }

    public Integer getN_pass() {
        return n_pass;
    }
    public void setN_pass(Integer n_pass) {
        this.n_pass = n_pass;
    }


}
