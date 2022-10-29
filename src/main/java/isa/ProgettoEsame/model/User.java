package isa.ProgettoEsame.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private LocalDate datebirth;
    private String sex;
    private String role;
    private String username;
    private String password;
    
    public int getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public LocalDate getDatebirth() {
        return datebirth;
    }

    public String getSex() {
        return sex;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public void setFirstname(String firstname) {
        this.firstname= firstname;
    }

    public void setLastname(String lastname) {
        this.lastname= lastname;
    }

    public void setSex(String sex) {
        this.sex= sex;
    }

    public void setDetebirth(LocalDate datebirth) {
        this.datebirth= datebirth;
    }

    public void setRole(String role) {
        this.role= role;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public void setUsername(String username) {
        this.username= username;
    }
}
