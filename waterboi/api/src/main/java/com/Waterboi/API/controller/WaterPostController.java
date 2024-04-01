package com.Waterboi.API.controller;

import com.Waterboi.API.entity.AppuserDetails;
import com.Waterboi.API.entity.Unit;
import com.Waterboi.API.entity.WaterPost;
import com.Waterboi.API.repository.AppuserRepository;
import com.Waterboi.API.repository.UnitRepository;
import com.Waterboi.API.repository.WaterPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/post")
public class WaterPostController {

    @Autowired
    private AppuserRepository appuserRepository;
    @Autowired
    private WaterPostRepository waterPostRepository;
    @Autowired
    private UnitRepository unitRepository;

    @GetMapping("/units")
    public List<Unit> getUnitsOfMeasure() {
        return unitRepository.findAll();
    }

    @GetMapping("/all")
    public List<WaterPost> getAllPosts(@AuthenticationPrincipal AppuserDetails appuserDetails) {
        Long userId = appuserDetails.getUserId();
        return waterPostRepository.findByAppuserId(userId);
    }

    @PostMapping("/new")
    public WaterPost newWaterPost(@AuthenticationPrincipal AppuserDetails appuserDetails,
                                  @RequestBody WaterPostDto waterPostDto) {
        Long userId = appuserDetails.getUserId();
        if (waterPostDto.quantity() < 0.0) {throw new IllegalArgumentException("Quantity cannot be negative.");}
        if (!unitRepository.existsById(waterPostDto.unitId())) {
            throw new NoSuchElementException("Unit ID not found");
        }

        return waterPostRepository.save(new WaterPost(
                userId,
                waterPostDto.quantity(),
                waterPostDto.unitId(),
                LocalDateTime.now()));
    }

}
