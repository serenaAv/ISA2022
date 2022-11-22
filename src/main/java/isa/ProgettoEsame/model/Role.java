package isa.ProgettoEsame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String role;

    public Role(int id, String role) {
        this.id = id;
        this.role=role;
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(String role) {
        this.role=role;
    }

    public Role()
    {

    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
