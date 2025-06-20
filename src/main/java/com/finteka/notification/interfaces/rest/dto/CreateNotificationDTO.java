package com.finteka.notification.interfaces.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.finteka.notification.domain.entity.Notification;
import java.time.LocalDateTime;

public class CreateNotificationDTO {
    private Long profesionalId;
    private String mensaje;

    public CreateNotificationDTO() {}

    @JsonCreator
    public CreateNotificationDTO(
            @JsonProperty("profesionalId") Long profesionalId,
            @JsonProperty("mensaje") String mensaje) {
        this.profesionalId = profesionalId;
        this.mensaje = mensaje;
    }

    public Notification toDomain() {
        return new Notification(null, profesionalId, mensaje, LocalDateTime.now(), false);
    }

    // Getters
    public Long getProfesionalId() { return profesionalId; }
    public String getMensaje() { return mensaje; }
}