package com.Waterboi.API.repository;

import com.Waterboi.API.entity.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppuserRepository extends JpaRepository<Appuser, Long> {
    Appuser findByUsernameIgnoreCase(String username);
}
