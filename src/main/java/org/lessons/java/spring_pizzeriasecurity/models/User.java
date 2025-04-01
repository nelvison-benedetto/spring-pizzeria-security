package org.lessons.java.spring_pizzeriasecurity.models;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "username cannot be blank.")
    @Column(unique = true)  //x additional security 
    private String username;

    @Size(min=6, message="password must be at least 6 chars.")
    @NotBlank(message = "password cannot be blank.")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(  //creazione schema nuova tabella
        name = "role_user",  //nome tabella join Intermedia
        joinColumns = @JoinColumn(name="user_id"),  //colonna x user 
        inverseJoinColumns = @JoinColumn(name="role_id"),  //colonna x role
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"})  //impedisce duplicati coppie user_id-role_id a livello db
        )
    private Set<Role> roles;  //set non permette duplicati same role linked to same user

}
