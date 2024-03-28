package com.waterboi.auth;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<WebUser, Long> {
}
