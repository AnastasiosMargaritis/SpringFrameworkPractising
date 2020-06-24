package com.security.configuration;

import com.security.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomSecurityUser extends User implements UserDetails {

    private static final long serialVersionUID = -123526131047887755L;

    public CustomSecurityUser(){}

    public CustomSecurityUser(User user) {
        this.setAuthorities(user.getAuthorities());
        this.setId(user.getId());
        this.setPassword(this.getPassword());
        this.setUsername(user.getUsername());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }
}
