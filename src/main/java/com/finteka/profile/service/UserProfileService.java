package com.finteka.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.finteka.profile.infrastructure.persistence.JpaUserProfileRepository;
import com.finteka.profile.infrastructure.persistence.models.UserProfileEntity;

@Service
public class UserProfileService {

    private final JpaUserProfileRepository repository;

    public UserProfileService(JpaUserProfileRepository repository) {
        this.repository = repository;
    }

    public List<UserProfileEntity> findAll() {
        return repository.findAll();
    }

    public Optional<UserProfileEntity> findById(Long id) {
        return repository.findById(id);
    }

    public UserProfileEntity save(UserProfileEntity userProfile) {
        return repository.save(userProfile);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}