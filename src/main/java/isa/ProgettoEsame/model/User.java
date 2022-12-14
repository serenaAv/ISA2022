
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
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    @Email(message = "Inserire una mail valida")
    private String email;

    @Column(name = "firstname")
    @NotBlank (message ="Devi inserire il nome")
    private String firstname;

    @NotBlank (message ="Devi inserire il cognome")
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sex")
    private String sex;

    @NotBlank (message ="Devi inserire lo username")
    @Column(name = "username")
    private String username;

    @Size(min = 3, max = 64, message ="Devi inserire una password di almeno 3 caratteri")
    @Column(name = "password")
    private String password;

    @Column(name="resetpwtoken")
    private String resetPwToken;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.DETACH}, fetch = FetchType.EAGER)
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

    public void addRole(Role role)
    {
        this.roles.add(role);
    }

/*    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
*/
    
    
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

    public String getResetPwToken() {
        return resetPwToken;
    }

    public void setId(Integer id) {
        if(id <=0){
            throw new IllegalArgumentException("Il linkId deve essere > 0.");
        }
        this.id = id;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public void setFirstname(String firstname) {
        if(firstname.length() > 30) {
            throw new IllegalArgumentException("Il nome pu?? avere massimo 30 caratteri.");
        }
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        if(lastname.length() > 30) {
            throw new IllegalArgumentException("Il cognome pu?? avere massimo 30 caratteri.");
        }
        this.lastname = lastname;
    }

    public void setSex(String sex) {
        this.sex= sex;
    }
    
    public void setPassword(String password) {
        if(password.length() > 64) {
            throw new IllegalArgumentException("La password pu?? avere al massimo 64 caratteri.");
        }
        this.password= password;
    }

    public void setUsername(String username) {
        if(username.length() > 20) {
            throw new IllegalArgumentException("Lo username pu?? avere massimo 20 caratteri.");
        }
        this.username= username;
    }

    public void setResetPwToken(String resetPwToken) {
        this.resetPwToken= resetPwToken;
    }

/*    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book;
    public List<Book> getBooks(){
        return book;
    }
    public void setBooks(List<Book> books){
        this.book = books;
    }
*/

    public User ()
    {
        
    }
}
