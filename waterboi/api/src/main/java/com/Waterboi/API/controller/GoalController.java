package com.Waterboi.API.controller;

import com.Waterboi.API.entity.AppuserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goal")
@Validated
public class GoalController {
    @GetMapping("/day")
    public double goalDay(@AuthenticationPrincipal AppuserDetails appuserDetails) {
<<<<<<< Updated upstream
        return 0.0;
    }
=======
        AppuserProfile appuserProfile = appuserProfileRepository.findByAppuserId(appuserDetails.getUserId())
                .orElseThrow();
        double dailyGoal = appuserProfile.getDailyGoal();
        validateGoal(dailyGoal);
        return dailyGoal;
    }

    @GetMapping("/week")
    public double goalWeek(@AuthenticationPrincipal AppuserDetails appuserDetails) {
        AppuserProfile appuserProfile = appuserProfileRepository.findByAppuserId(appuserDetails.getUserId())
                .orElseThrow();
        double weeklyGoal = appuserProfile.getDailyGoal() * 7;
        validateGoal(weeklyGoal);
        return weeklyGoal;
    }

    private void validateGoal(double goal){
        if (goal <= 0 || goal >= 1000){
            throw new IllegalArgumentException("Invalid Goal Value");
        }
    }
>>>>>>> Stashed changes
}
