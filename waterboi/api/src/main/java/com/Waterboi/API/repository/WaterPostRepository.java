package com.Waterboi.API.repository;

import com.Waterboi.API.entity.WaterPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaterPostRepository extends JpaRepository<WaterPost, Long> {
    public List<WaterPost> findByAppuserId(Long appuserId);
}
