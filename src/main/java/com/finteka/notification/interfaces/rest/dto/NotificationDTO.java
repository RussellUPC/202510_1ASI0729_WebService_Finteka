package com.finteka.notification.interfaces.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.finteka.notification.domain.entity.Notification;
import java.time.LocalDateTime;

public class NotificationDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("profesionalId")
    private Long profesionalId;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonProperty("fecha")
    private LocalDateTime fecha;

    @JsonProperty("leida")
    private boolean leida;

    public NotificationDTO() {}

    public static NotificationDTO fromDomain(Notification n) {
        NotificationDTO dto = new NotificationDTO();
        dto.id = n.getId();
        dto.profesionalId = n.getProfesionalId();
        dto.titulo = n.getTitulo();
        dto.mensaje = n.getMensaje();
        dto.fecha = n.getFecha();
        dto.leida = n.isLeida();
        return dto;
    }

    // Getters
    public Long getId() { return id; }
    public Long getProfesionalId() { return profesionalId; }
    public String getTitulo() { return titulo; }
    public String getMensaje() { return mensaje; }
    public LocalDateTime getFecha() { return fecha; }
    public boolean isLeida() { return leida; }
}
