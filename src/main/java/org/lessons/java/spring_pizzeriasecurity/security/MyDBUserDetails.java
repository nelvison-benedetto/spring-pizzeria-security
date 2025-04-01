package org.lessons.java.spring_pizzeriasecurity.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.lessons.java.spring_pizzeriasecurity.models.Role;

import org.lessons.java.spring_pizzeriasecurity.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MyDBUserDetails implements UserDetails{
    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public MyDBUserDetails(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = new HashSet<>();

        for(Role userRole : user.getRoles() ){
            authorities.add(new SimpleGrantedAuthority(userRole.getName()) );
        }
    }

    //set all true, not necessary restrictions now.
    @Override
    public boolean isAccountNonExpired(){return true;}
    @Override
    public boolean isAccountNonLocked(){return true;}
    @Override
    public boolean isCredentialsNonExpired(){return true;}
    @Override
    public boolean isEnabled(){return true;}


    //i am using my @Getter @Setter
    // @Override   
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    // }
    // @Override
    // public String getPassword() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    // }
    // @Override
    // public String getUsername() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    // }
    
}
