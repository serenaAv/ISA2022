package isa.ProgettoEsame.repository;

import isa.ProgettoEsame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer>{
    //se hai problemi prova a metterlo public
    User findByUsername(String username);
    User findByEmail(String email);

    User findByResetPwToken(String reset_Pw_Token);
}