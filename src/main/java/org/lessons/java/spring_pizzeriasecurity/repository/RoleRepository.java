package org.lessons.java.spring_pizzeriasecurity.repository;

import org.lessons.java.spring_pizzeriasecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
