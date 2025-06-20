package com.finteka.profile.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.finteka.profile.domain.entities.UserProfile;
import com.finteka.profile.domain.repositories.UserProfileRepository;
import com.finteka.profile.domain.valueobjects.UserName;
import com.finteka.profile.infrastructure.persistence.models.UserProfileEntity;

@Repository
public class UserProfileRepositoryImpl implements UserProfileRepository {

    private final JpaUserProfileRepository jpaRepo;

    public UserProfileRepositoryImpl(JpaUserProfileRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<UserProfile> findById(Long id) {
        return jpaRepo.findById(id).map(this::mapToDomain);
    }

    @Override
    public List<UserProfile> findAll() {
        return jpaRepo.findAll().stream().map(this::mapToDomain).collect(Collectors.toList());
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        UserProfileEntity entity = mapToEntity(userProfile);
        return mapToDomain(jpaRepo.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    // Mapea de entidad JPA a dominio
    private UserProfile mapToDomain(UserProfileEntity entity) {
        return new UserProfile(
            entity.getId(),
            new UserName(entity.getName()), // aquí conviertes String a UserName
            entity.getEmail()
        );
    }

    // Mapea de dominio a entidad JPA
    private UserProfileEntity mapToEntity(UserProfile userProfile) {
        UserProfileEntity entity = new UserProfileEntity();
        entity.setId(userProfile.getId());
        entity.setName(userProfile.getName().getValue()); // aquí conviertes UserName a String
        entity.setEmail(userProfile.getEmail());
        return entity;
    }
}