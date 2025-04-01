package org.lessons.java.spring_pizzeriasecurity.seeders;

import java.util.HashSet;
import java.util.Set;

import org.lessons.java.spring_pizzeriasecurity.models.Role;
import org.lessons.java.spring_pizzeriasecurity.models.User;
import org.lessons.java.spring_pizzeriasecurity.repository.RoleRepository;
import org.lessons.java.spring_pizzeriasecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void seed(){
        //creations Role entities
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        Role userRole = new Role();
        userRole.setName("USER");

        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        //Creations User entitites
        User adminUser = new User();
        adminUser.setUsername("personAdmin");
        adminUser.setPassword(passwordEncoder.encode("12345678"));  //encryption applied
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);      //add role ADMIN
        adminUser.setRoles(adminRoles);
        userRepository.save(adminUser);

        User normalUser = new User();
        normalUser.setUsername("personNoAdmin");
        normalUser.setPassword("{noop}12345678");  //!noop x Password NO encryption, only x didactic purposes
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);     //add role USER
        normalUser.setRoles(userRoles);
        userRepository.save(normalUser);
    }
}
