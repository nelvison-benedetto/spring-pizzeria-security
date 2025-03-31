package org.lessons.java.spring_pizzeriasecurity.repository;

import org.lessons.java.spring_pizzeriasecurity.models.Review;
import org.lessons.java.spring_pizzeriasecurity.models.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Integer>{
    //!You have now automatically inherited CRUD methods like save(), findAll(), etc., through Spring JPA Query Methods
    
}
