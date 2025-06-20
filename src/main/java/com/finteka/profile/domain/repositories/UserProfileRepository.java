package com.finteka.profile.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.finteka.profile.domain.entities.UserProfile;

public interface UserProfileRepository {
    Optional<UserProfile> findById(Long id);
    List<UserProfile> findAll();
    UserProfile save(UserProfile userProfile);
    void deleteById(Long id);
}