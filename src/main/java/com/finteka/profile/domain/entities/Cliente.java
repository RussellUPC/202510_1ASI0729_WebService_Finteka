package com.finteka.profile.domain.entities;

public class Cliente {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String telefono;

    public Cliente(Long id, String nombre, String email, String password, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    // No getter for password for security reasons

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
