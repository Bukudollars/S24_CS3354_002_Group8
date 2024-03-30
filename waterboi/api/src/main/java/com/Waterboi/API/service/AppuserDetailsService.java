package com.Waterboi.API.service;

import com.Waterboi.API.entity.Appuser;
import com.Waterboi.API.repository.AppuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppuserDetailsService implements UserDetailsService {
    @Autowired
    private AppuserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Appuser appuser = repository.findByUsernameIgnoreCase(username).orElseThrow();
        User.UserBuilder builder = null;
        if(appuser != null) {
            builder = User.withUsername(username);
            builder.password(appuser.getPassword());
            builder.roles("USER");
        } else {
            throw new UsernameNotFoundException("User not found/");
        }
        return builder.build();
    }

}
