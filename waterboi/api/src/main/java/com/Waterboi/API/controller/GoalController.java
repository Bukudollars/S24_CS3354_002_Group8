package com.Waterboi.API.controller;

import com.Waterboi.API.entity.AppuserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goal")
public class GoalController {
    @GetMapping("/day")
    public double goalDay(@AuthenticationPrincipal AppuserDetails appuserDetails) {
        return 0.0;
    }
}
