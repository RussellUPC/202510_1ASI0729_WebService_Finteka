package com.finteka.profile.domain.entities;

public class Profesional {
    private Long id;
    private String nombre;
    private String especialidad;
    private double calificacion;
    private boolean disponibilidad;
    private String email;
    private String password;
    private String telefono;
    private String descripcion;

    public Profesional(Long id, String nombre, String especialidad, double calificacion, boolean disponibilidad, String email, String password, String telefono, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.calificacion = calificacion;
        this.disponibilidad = disponibilidad;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public double getCalificacion() { return calificacion; }
    public boolean isDisponibilidad() { return disponibilidad; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getDescripcion() { return descripcion; }
    // No getter for password for security reasons

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }
    public void setDisponibilidad(boolean disponibilidad) { this.disponibilidad = disponibilidad; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}

