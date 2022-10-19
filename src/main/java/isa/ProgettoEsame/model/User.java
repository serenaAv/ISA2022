package isa.ProgettoEsame.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String email;
    private String firstname;
    private String lastname;
    private Boolean enabled;
    private String sex;
    private LocalDate date_birth;
    private String role;
    private String password;
    private String username;
    
    
    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public Boolean getEnabled() {
        return enabled;
    }
    
    public String getSex() {
        return sex;
    }
    
    public LocalDate getDate_birth() {
        return date_birth;
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

    public void setEmail(String email) {
        this.email= email;
    }

    public void setFirstname(String firstname) {
        this.firstname= firstname;
    }

    public void setLastname(String lastname) {
        this.lastname= lastname;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled= enabled;
    }

    public void setSex(String sex) {
        this.sex= sex;
    }

    public void setDete_birth(LocalDate date_birth) {
        this.date_birth= date_birth;
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
