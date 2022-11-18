package isa.ProgettoEsame.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import isa.ProgettoEsame.model.Role;
import isa.ProgettoEsame.model.User;
import isa.ProgettoEsame.repository.RoleRepository;
import isa.ProgettoEsame.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List < User > getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPw = encoder.encode(user.getPassword());
        user.setPassword(encodedPw);

        Role roleUser = roleRepository.findByRole("User");
        user.addRole(roleUser);

        this.userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        Optional < User > optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + id);
        }
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    //setto un token univo allo user che deve resettare la pw e lo trovo tramite la mail che mi viene data
    @Override
    public void updateResetPwToken(String token, String email) throws EmailNotFoundException
    {
        User user = userRepository.findByEmail(email);
        if (user != null)
        {
            user.setResetPwToken(token);
            userRepository.save(user);
        }
        else
        {
            throw new EmailNotFoundException("Non esiste nessun utente con "+email+"come mail");
        }
    }

    //tiro fuori l'utente in base al token (è univoco)
    @Override
    public User getUserByResetPwToken(String resetPwToken)
    {
        return userRepository.findByResetPwToken(resetPwToken);
    }

    //aggiorno la pw che mi viene data e resetto il token
    public void updatePw(User user, String newPw)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePw = encoder.encode(newPw);
        user.setPassword(encodePw);
        user.setResetPwToken(null);

        userRepository.save(user);
    }
}