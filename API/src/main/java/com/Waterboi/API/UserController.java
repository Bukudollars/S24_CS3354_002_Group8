package com.Waterboi.API;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/users/{id}")
    WebUser findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new userNotFoundException(id));
    }

}
