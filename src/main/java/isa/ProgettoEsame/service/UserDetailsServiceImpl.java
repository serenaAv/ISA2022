package isa.ProgettoEsame.service;

import isa.ProgettoEsame.model.User;
import isa.ProgettoEsame.repository.UserRepository;
import isa.ProgettoEsame.model.MyUserDetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        
        //adesso prendo sto userobject proveniente dal userrepository, lo converto in una myuserdetails instance e lo vado a restituire
        return user.map(MyUserDetails::new).get();
    }
 
} 