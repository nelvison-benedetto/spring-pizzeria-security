package org.lessons.java.spring_pizzeriasecurity.repository;

import org.lessons.java.spring_pizzeriasecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer>{
    
    Optional<User> findByUsername(String username);
}
