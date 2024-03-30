package com.Waterboi.API.repository;

import com.Waterboi.API.model.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppuserRepository extends JpaRepository<Appuser, Long> {
    Appuser findByUsernameIgnoreCase(String username);
}
