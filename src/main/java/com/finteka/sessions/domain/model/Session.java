package com.finteka.sessions.domain.model;

import com.finteka.sessions.domain.model.enums.SessionStatus;

import java.time.LocalDateTime;

public class Session {

    private Long id;
    private Long profesionalId;
    private Long clienteId;
    private LocalDateTime fecha;
    private SessionStatus estado;
    private Integer duracion;

    public Session(Long id, Long profesionalId, Long clienteId, LocalDateTime fecha, SessionStatus estado) {
        this.id = id;
        this.profesionalId = profesionalId;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.estado = estado;
        this.duracion = 30;
    }

    public Session(Long id, Long profesionalId, Long clienteId, LocalDateTime fecha, SessionStatus estado, Integer duracion) {
        this.id = id;
        this.profesionalId = profesionalId;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.estado = estado;
        this.duracion = duracion != null ? duracion : 30;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(Long profesionalId) {
        this.profesionalId = profesionalId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public SessionStatus getEstado() {
        return estado;
    }

    public void setEstado(SessionStatus estado) {
        this.estado = estado;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
}
