package com.finteka.notification.domain.service;

import com.finteka.notification.domain.entity.Notification;
import java.util.List;

public interface ListNotificationsService {
    List<Notification> execute(Long profesionalId);
}