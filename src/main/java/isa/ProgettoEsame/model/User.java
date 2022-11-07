package isa.ProgettoEsame.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable  (name = "usersroles",
                joinColumns = @JoinColumn(name = "id_user"),
                inverseJoinColumns = @JoinColumn (name="role_id"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles(){
        return roles;
    }

    public void setRoles(Set<Role> roles){
        this.roles = roles;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable  (name = "books",
                joinColumns = @JoinColumn(name = "id_user"),
                inverseJoinColumns = @JoinColumn (name="id_trav"))
    private Set<Travel> travels = new HashSet<>();

    public Set<Travel> getTravels(){
        return travels;
    }

    public void setTravels(Set<Travel> travels){
        this.travels = travels;
    }

    
    
    public Integer getId() {
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
    
    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Integer id) {
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
    
    public void setPassword(String password) {
        this.password= password;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book;
    public List<Book> getBooks(){
        return book;
    }
    public void setBooks(List<Book> books){
        this.book = books;
    }
}
