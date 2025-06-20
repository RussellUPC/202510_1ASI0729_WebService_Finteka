package com.finteka.notification.infrastructure.persistence.jpa.repository;

import com.finteka.notification.infrastructure.persistence.jpa.model.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SpringNotificationJpa extends JpaRepository<NotificationEntity, Long> {
    List<NotificationEntity> findByProfesionalId(Long profesionalId);
}
