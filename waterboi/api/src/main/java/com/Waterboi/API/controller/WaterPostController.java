package com.Waterboi.API.controller;

import com.Waterboi.API.entity.WaterPost;
import com.Waterboi.API.repository.AppuserRepository;
import com.Waterboi.API.repository.WaterPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class WaterPostController {

    @Autowired
    private AppuserRepository appuserRepository;
    @Autowired
    private WaterPostRepository waterPostRepository;

    @GetMapping("/all")
    public List<WaterPost> getAllPosts() {
        return waterPostRepository.findAll();
    }

}
