package org.lessons.java.spring_pizzeriasecurity.repository;

import org.lessons.java.spring_pizzeriasecurity.models.Pizza;
import org.lessons.java.spring_pizzeriasecurity.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
    //!You have now automatically inherited CRUD methods like save(), findAll(), etc., through Spring JPA Query Methods

}
