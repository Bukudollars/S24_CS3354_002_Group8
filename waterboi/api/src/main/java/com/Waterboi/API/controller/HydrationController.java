package com.Waterboi.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hydration")
public class HydrationController {

    @PostMapping("/add")
    public ResponseEntity<String> addHydrationEvent(@RequestParam String drink, @RequestParam int amount) {
        if ("Water".equals(drink) && amount > 0) {
            //Update
            return ResponseEntity.ok("Success update");

        } else {
            if (!"Water".equals(drink)) {
                return ResponseEntity.badRequest().body("Show error message");
            }
            return ResponseEntity.badRequest().body("Invalid input");
        }



    }

}
