package org.lessons.java.spring_pizzeriasecurity.repository;

import org.lessons.java.spring_pizzeriasecurity.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
    //!You have now automatically inherited CRUD methods like save(), findAll(), etc., through Spring JPA Query Methods

    
}
