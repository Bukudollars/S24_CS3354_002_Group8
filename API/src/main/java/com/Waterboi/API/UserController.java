package com.Waterboi.API;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/users")
    List<WebUser> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    WebUser newWebUser(@RequestBody WebUser newWebUser) {
        return repository.save(newWebUser);
    }
    
}
