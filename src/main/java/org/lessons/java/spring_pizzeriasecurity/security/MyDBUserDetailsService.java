package org.lessons.java.spring_pizzeriasecurity.security;

import org.lessons.java.spring_pizzeriasecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import org.lessons.java.spring_pizzeriasecurity.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyDBUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;  //removed 'final' and added @Autowired, no construct otherwise in SecurityConfig.java i should have added the params when i was going to call this class

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            return new MyDBUserDetails(userOptional.get());  
        }
        throw new UsernameNotFoundException("No user found with username "+ username);
    }
    
}
