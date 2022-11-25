package isa.ProgettoEsame.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "travels")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotBlank (message ="Devi inserire la data")
    @Column(name = "date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @NotBlank (message ="Devi inserire la partenza")
    @Column(name = "time_dep_real")
    private String time_dep_real;

    @NotBlank (message ="Devi inserire l'arrivo")
    @Column(name = "time_arr_real")
    private String time_arr_real;



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

/*    @ManyToMany(mappedBy = "travels")
    private Set<User> users = new HashSet<>();
    public Set<User> getUsers(){
        return users;
    }

    public void setUsers(Set<User> users){
        this.users = users;
    }
*/
/*    @OneToMany(mappedBy = "travel",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book;
    public List<Book> getBooks(){
        return book;
    }
    public void setBooks(List<Book> books){
        this.book = books;
    }
*/
    




    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        if(id <=0){
            throw new IllegalArgumentException("Il linkId deve essere > 0.");
        }
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
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



}
