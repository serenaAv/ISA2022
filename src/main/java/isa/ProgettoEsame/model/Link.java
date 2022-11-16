package isa.ProgettoEsame.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "links")

public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank (message ="Devi inserire la destinazione")
    @Column(name = "destination")
    private String destination;

    @NotBlank (message ="Devi inserire il tempo")
    @Column(name = "time")
    private String time;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }






    @OneToMany(mappedBy = "link", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Travel> travels;
    public List<Travel> getTravels(){
        return travels;
    }
    public void setTravels(List<Travel> travels){
        this.travels = travels;
    }

}
