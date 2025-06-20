package com.finteka.profile.interfaces.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finteka.profile.infrastructure.persistence.models.UserProfileEntity;
import com.finteka.profile.service.UserProfileService;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfileEntity> getAllProfiles() {
        return userProfileService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileEntity> getProfile(@PathVariable Long id) {
        return userProfileService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserProfileEntity createProfile(@RequestBody UserProfileEntity userProfile) {
        return userProfileService.save(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileEntity> updateProfile(@PathVariable Long id, @RequestBody UserProfileEntity userProfile) {
        return userProfileService.findById(id)
            .map(existing -> {
                userProfile.setId(id);
                return ResponseEntity.ok(userProfileService.save(userProfile));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        if (userProfileService.findById(id).isPresent()) {
            userProfileService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}