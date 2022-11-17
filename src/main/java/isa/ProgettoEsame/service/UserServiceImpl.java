package isa.ProgettoEsame.service;

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
}