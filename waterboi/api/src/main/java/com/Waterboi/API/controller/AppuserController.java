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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
