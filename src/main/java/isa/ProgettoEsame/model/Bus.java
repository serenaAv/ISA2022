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
import isa.ProgettoEsame.model.Travel;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "y")
    private Integer y;

    @Column(name = "description")
    private String description;

    @Column(name = "date_last_rev")
    private String date_last_rev;

    @Column(name = "date_last_carserv")
    private String date_last_carserv;
    


    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Travel> travels;
    public List<Travel> getTravels(){
        return travels;
    }
    public void setTravels(List<Travel> travels){
        this.travels = travels;
    }




    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_last_rev() {
        return date_last_rev;
    }
    public void setDate_last_rev(String date_last_rev) {
        this.date_last_rev = date_last_rev;
    }

    public String getDate_last_carserv() {
        return date_last_carserv;
    }
    public void setDate_last_carserv(String date_last_carserv) {
        this.date_last_carserv = date_last_carserv;
    }
}
