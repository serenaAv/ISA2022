package isa.ProgettoEsame.repository;

import isa.ProgettoEsame.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername(String username);
}