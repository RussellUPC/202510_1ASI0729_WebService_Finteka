package com.finteka.notification.domain.repository;

import com.finteka.notification.domain.entity.Notification;
import java.util.List;

public interface NotificationRepository {
    List<Notification> findByProfesionalId(Long profesionalId);
    Notification save(Notification notification);

    void markAsRead(Long id);
}
