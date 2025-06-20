package com.finteka.notification.infrastructure.persistence.jpa.repository;

import com.finteka.notification.domain.entity.Notification;
import com.finteka.notification.domain.repository.NotificationRepository;
import com.finteka.notification.infrastructure.persistence.jpa.model.NotificationEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JpaNotificationRepository implements NotificationRepository {
    private final SpringNotificationJpa jpa;
    public JpaNotificationRepository(SpringNotificationJpa jpa) {
        this.jpa = jpa;
    }
    @Override
    public List<Notification> findByProfesionalId(Long profesionalId) {
        return jpa.findByProfesionalId(profesionalId).stream()
                .map(e -> new Notification(e.getId(), e.getProfesionalId(), e.getTitulo() , e.getMensaje(), e.getFecha(), e.isLeida()))
                .toList();
    }
    @Override
    public Notification save(Notification notification) {
        NotificationEntity e = new NotificationEntity();
        e.setProfesionalId(notification.getProfesionalId());
        e.setTitulo(notification.getTitulo());
        e.setMensaje(notification.getMensaje());
        e.setFecha(notification.getFecha());
        e.setLeida(notification.isLeida());
        NotificationEntity saved = jpa.save(e);
        notification.setId(saved.getId());
        return notification;
    }
    @Override
    public void markAsRead(Long id) {
        NotificationEntity e = jpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificacion no encontrada: " + id));
        e.setLeida(true);
        e.setFecha(LocalDateTime.now());
        jpa.save(e);
    }
}
