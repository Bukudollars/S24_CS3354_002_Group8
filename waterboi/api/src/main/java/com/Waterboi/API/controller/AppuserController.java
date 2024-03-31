package com.Waterboi.API.controller;

import com.Waterboi.API.entity.AppuserDetails;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AppuserController {
    @GetMapping("/id")
    public Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof AppuserDetails) {
            AppuserDetails appuserDetails = (AppuserDetails) authentication.getPrincipal();
            return appuserDetails.getUserId();
        } else {throw new AuthenticationCredentialsNotFoundException("User is not authenticated");}
    }
}
