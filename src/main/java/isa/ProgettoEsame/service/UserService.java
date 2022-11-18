package isa.ProgettoEsame.service;

import java.util.List;

import isa.ProgettoEsame.model.User;

public interface UserService {
    List < User > getAllUser();
    void saveUser(User user);
    void saveUserWithoutPw(User user);
    User getUserById(int id);
    void deleteUserById(int id);
    void updateResetPwToken(String token,String email) throws EmailNotFoundException;
    User getUserByResetPwToken(String resetPwToken);
    void updatePw(User user, String newPw);
}
