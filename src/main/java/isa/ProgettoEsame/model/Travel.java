package isa.ProgettoEsame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Column(name = "id_bus")
    private Integer id_bus;

    @Column(name = "id_link")
    private Integer id_link;

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

    public Integer getId_bus() {
        return id_bus;
    }
    public void setId_bus(Integer id_bus) {
        this.id_bus = id_bus;
    }

    public Integer getId_link() {
        return id_link;
    }
    public void setId_link(Integer id_link) {
        this.id_link = id_link;
    }


}
