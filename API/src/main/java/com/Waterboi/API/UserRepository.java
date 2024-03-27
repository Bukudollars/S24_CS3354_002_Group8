package com.Waterboi.API;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<WebUser, Long> {
    List<WebUser> findByUsernameIgnoreCase(String username);
}
