package isa.ProgettoEsame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import isa.ProgettoEsame.model.Role;
import isa.ProgettoEsame.model.User;
import isa.ProgettoEsame.repository.RoleRepository;
import isa.ProgettoEsame.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired RoleRepository roleRepository;

    @Autowired
    private TestEntityManager entityManager;

    //Creo un utente e lo inserisco nel db
    @Test
    public void testCreateUser()
    {
        User user = new User();

        user.setEmail("TestEmail@gmail.com");
        user.setFirstname("Test");
        user.setLastname("Test");
        user.setSex("M");
        user.setUsername("Test");
        user.setPassword("Test");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertEquals(existUser.getEmail(), user.getEmail());
    }

    //Corretta ricerca di un utente tramite la sua email
    @Test
    public void testFindUserByEmail()
    {
        String email = "detratti@gmail.com";
        User user = userRepository.findByEmail(email);
        assertNotNull(user);
    }

    //Corretto assegnamento di un ruolo ad un nuovo utente
    @Test
    public void testAddRoleToNewUser()
    {
        User user = new User();

        user.setEmail("TestEmail@gmail.com");
        user.setFirstname("Test");
        user.setLastname("Test");
        user.setSex("M");
        user.setUsername("Test");
        user.setPassword("Test");

        Role roleUser = roleRepository.findByRole("user");
        user.addRole(roleUser);

        User savedUser = userRepository.save(user);
        
        assertEquals(savedUser.getRoles().size(), 1);

    }   

    //corretto assegnamento di più ruoli ad un singolo utente
    @Test
    public void testAddRolesToExistingUser()
    {
        User user = userRepository.findById(50).get();
        Role roleUser = roleRepository.findByRole("user");
        user.addRole(roleUser);

        Role roleAdmin = new Role(1);
        user.addRole(roleAdmin);

        User savedUser = userRepository.save(user);
        assertEquals(savedUser.getRoles().size(), 2);
    }
}
