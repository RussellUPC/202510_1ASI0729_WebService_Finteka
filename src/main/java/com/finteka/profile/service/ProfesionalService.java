package com.finteka.profile.service;

import com.finteka.profile.infrastructure.persistence.models.ProfesionalEntity;
import com.finteka.profile.infrastructure.persistence.repositories.ProfesionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalService {
    private final ProfesionalRepository profesionalRepository;

    public ProfesionalService(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;
    }

    public List<ProfesionalEntity> findAll() {
        return profesionalRepository.findAll();
    }

    public Optional<ProfesionalEntity> findById(Long id) {
        return profesionalRepository.findById(id);
    }

    public ProfesionalEntity save(ProfesionalEntity profesional) {
        return profesionalRepository.save(profesional);
    }

    public void deleteById(Long id) {
        profesionalRepository.deleteById(id);
    }
}

