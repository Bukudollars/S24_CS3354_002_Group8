package com.Waterboi.API.controller;

import com.Waterboi.API.entity.AppuserDetails;
import com.Waterboi.API.entity.AppuserProfile;
import com.Waterboi.API.repository.AppuserProfileRepository;
import com.Waterboi.API.repository.AppuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/user")
public class AppuserController {
    @Autowired
    private AppuserRepository appuserRepository;
    @Autowired
    private AppuserProfileRepository appuserProfileRepository;
    @GetMapping("/id")
    public Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof AppuserDetails) {
            AppuserDetails appuserDetails = (AppuserDetails) authentication.getPrincipal();
            return appuserDetails.getUserId();
        } else {throw new AuthenticationCredentialsNotFoundException("User is not authenticated");}
    }
    @GetMapping("/profile")
    public AppuserProfile getAppuserProfile(@AuthenticationPrincipal AppuserDetails appuserDetails) {
        return appuserProfileRepository.findByAppuserId(appuserDetails.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }
    @PostMapping("/profile/goal/day")
    public double setDailyGoal(@AuthenticationPrincipal AppuserDetails appuserDetails, @RequestBody GoalDto goalDto) {
        AppuserProfile appuserProfile = appuserProfileRepository.findByAppuserId(appuserDetails.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        appuserProfile.setDailyGoal(goalDto.goal());
        appuserProfileRepository.save(appuserProfile);
        return goalDto.goal();
    }
    private record GoalDto(double goal) {}
}
