package com.Waterboi.API.controller;

import com.Waterboi.API.entity.AppuserDetails;
import com.Waterboi.API.entity.UnitOfMeasure;
import com.Waterboi.API.entity.WaterPost;
import com.Waterboi.API.repository.AppuserRepository;
import com.Waterboi.API.repository.UnitOfMeasureRepository;
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
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @GetMapping("/unitOfMeasure")
    public List<UnitOfMeasure> getUnitsOfMeasure() {
        return unitOfMeasureRepository.findAll();
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
        if (!unitOfMeasureRepository.existsById(waterPostDto.unitOfMeasureId())) {
            throw new NoSuchElementException("Unit of measure ID not found");
        }

        return waterPostRepository.save(new WaterPost(
                userId,
                waterPostDto.quantity(),
                waterPostDto.unitOfMeasureId(),
                LocalDateTime.now()));
    }

}
