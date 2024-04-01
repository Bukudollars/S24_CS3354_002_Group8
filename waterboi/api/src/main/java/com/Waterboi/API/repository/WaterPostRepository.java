package com.Waterboi.API.repository;

import com.Waterboi.API.entity.WaterPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WaterPostRepository extends JpaRepository<WaterPost, Long> {
    public List<WaterPost> findByAppuserId(Long appuserId);
    @Query("SELECT SUM(post.quantity) FROM WaterPost post WHERE post.appuserId = :appuserId")
    public double sumQuantity(Long appuserId);
}
