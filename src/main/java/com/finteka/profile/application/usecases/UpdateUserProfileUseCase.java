package com.finteka.profile.application.usecases;

import com.finteka.profile.domain.repositories.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserProfileUseCase {
    private final UserProfileRepository repository;

    public UpdateUserProfileUseCase(UserProfileRepository repository) {
        this.repository = repository;
    }

    public void execute(Long userId, String newName, String newEmail) {
        // Lógica para actualizar el perfil
    }
}