package com.Waterboi.API.repository;

import com.Waterboi.API.entity.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Long> {
    public Optional<UnitOfMeasure> findByNameIgnoreCase(String name);
}
