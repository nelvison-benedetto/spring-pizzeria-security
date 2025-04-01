package org.lessons.java.spring_pizzeriasecurity.security;

import org.lessons.java.spring_pizzeriasecurity.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  //dice a spring di usare this config x all requests 'web security '
public class SecurityConfiguration {
    
    @Bean
    @SuppressWarnings("removal") //x evitare errori di deprecazione e x non settings perfetti come vuole attuale versione spring sec ect
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
            .requestMatchers("/pizzas/create", "pizzas/edit/**").hasAuthority("ADMIN")
            .requestMatchers(HttpMethod.POST, "/pizzas/**").hasAuthority("ADMIN")
            .requestMatchers("/ingredients", "/ingredients/**").hasAuthority("ADMIN")
            .requestMatchers("/reviews", "/reviews/**").hasAuthority("ADMIN")
            .requestMatchers("/specialoffers", "/specialoffers/**").hasAuthority("ADMIN")

            .requestMatchers("/pizzas", "/pizzas/**").hasAnyAuthority("USER","ADMIN")  // __Any__ x more than 1 
            //.requestMatchers("/login", "/logout").permitAll()
            
            .requestMatchers("/**").permitAll()  //public access for all other pages

            .and().formLogin()
            .and().logout()
            .and().exceptionHandling();

        return http.build();
    }

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    
        authProvider.setUserDetailsService(userDetailsService()); 
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    MyDBUserDetailsService userDetailsService(){
        return new MyDBUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
