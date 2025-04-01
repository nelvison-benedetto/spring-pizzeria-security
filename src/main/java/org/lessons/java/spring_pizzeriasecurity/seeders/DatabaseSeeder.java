package org.lessons.java.spring_pizzeriasecurity.seeders;

import org.hibernate.annotations.Comment;
import org.lessons.java.spring_pizzeriasecurity.seeders.IngredientSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner{
    
    private final PizzaSeeder pizzaSeeder;
    private final ReviewSeeder reviewSeeder;
    private final SpecialOfferSeeder specialOfferSeeder;
    private final IngredientSeeder ingredientSeeder;
    private final UserSeeder userSeeder;

    @Autowired  //inject instance PizzaSeeder & ReviewSeeder in this instance DatabaseSeeder
    public DatabaseSeeder(PizzaSeeder pizzaSeeder, ReviewSeeder reviewSeeder, SpecialOfferSeeder specialOfferSeeder, IngredientSeeder ingredientSeeder, UserSeeder userSeeder){
        this.pizzaSeeder = pizzaSeeder;
        this.reviewSeeder = reviewSeeder;
        this.specialOfferSeeder = specialOfferSeeder;
        this.ingredientSeeder = ingredientSeeder;
        this.userSeeder = userSeeder;
    }

    @Override
    public void run(String... args){
        pizzaSeeder.seed();
        reviewSeeder.seed(15);
        specialOfferSeeder.seed();
        ingredientSeeder.seed();
        userSeeder.seed();
    }
}
