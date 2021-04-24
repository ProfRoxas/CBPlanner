package hu.elte.CbPlanner.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import hu.elte.CbPlanner.entities.User;

public class CbUserPrincipal implements UserDetails {
    private User user;

    public CbUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Simple roles: ADMIN > COMP > USER > ANON
        var auths = Arrays.asList(new SimpleGrantedAuthority("USER"));
        user.getRole();
        switch (user.getRole()) {
            case "ADMIN":
                auths.add(new SimpleGrantedAuthority("ADMIN"));
            case "COMP":
                auths.add(new SimpleGrantedAuthority("COMP"));
            default:
                break;
        }
        return auths;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}