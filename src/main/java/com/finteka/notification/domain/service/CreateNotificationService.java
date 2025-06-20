package com.finteka.notification.domain.service;

import com.finteka.notification.domain.entity.Notification;

public interface CreateNotificationService {
    Notification execute(Notification notification);
}

