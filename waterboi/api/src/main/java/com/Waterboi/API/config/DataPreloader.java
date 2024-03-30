package com.Waterboi.API.config;

import com.Waterboi.API.entity.Appuser;
import com.Waterboi.API.repository.AppuserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataPreloader {
    @Bean
    CommandLineRunner initDatabase(AppuserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            repository.save(new Appuser("user", passwordEncoder.encode("password")));
        };
    }
}
