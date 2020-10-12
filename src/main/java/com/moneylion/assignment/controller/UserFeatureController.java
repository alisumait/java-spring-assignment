package com.moneylion.assignment.controller;

import javax.validation.Valid;

import com.moneylion.assignment.model.UserFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moneylion.assignment.repository.UserFeatureRepository;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class UserFeatureController {
    @Autowired
    private UserFeatureRepository UserFeatureRepository;

    @GetMapping("/feature")
    public ResponseEntity isFeatureEnabled(@RequestParam String email, @RequestParam String featureName) {
        UserFeature record = UserFeatureRepository.findByEmailAndFeatureName(email, featureName);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("canAccess", record.isEnabled());
        return ResponseEntity.ok().body(map);
    }

    @PostMapping("/feature")
    public ResponseEntity createOrUpdateFeature(@RequestBody @Valid UserFeature userFeature) {
        try {
            UserFeature record = UserFeatureRepository.findByEmailAndFeatureName(userFeature.getEmail(), userFeature.getFeatureName());
            if (record == null) {
                UserFeatureRepository.saveAndFlush(userFeature);
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else {
                record.setEnabled(userFeature.isEnabled());
                UserFeatureRepository.saveAndFlush(record);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

}