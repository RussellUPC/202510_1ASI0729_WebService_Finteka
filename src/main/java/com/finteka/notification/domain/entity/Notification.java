package com.finteka.notification.domain.entity;

import java.time.LocalDateTime;

public class Notification {
    private Long id;
    private Long profesionalId;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private boolean leida;

    public Notification() {}

    public Notification(Long id, Long profesionalId, String titulo ,String mensaje, LocalDateTime fecha, boolean leida) {
        this.id = id;
        this.profesionalId = profesionalId;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.leida = leida;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProfesionalId() { return profesionalId; }
    public void setProfesionalId(Long profesionalId) { this.profesionalId = profesionalId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public boolean isLeida() { return leida; }
    public void setLeida(boolean leida) { this.leida = leida; }
}

