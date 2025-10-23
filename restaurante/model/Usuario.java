package com.restaurante.model;

public class Usuario {
    private Integer idUsuario;
    private Integer idEmpleado;
    private String username;
    private String password;
    private String rol;
    private String estado;

    public Usuario() {}

    public Usuario(Integer idUsuario, Integer idEmpleado, String username, String password, String rol, String estado) {
        this.idUsuario = idUsuario;
        this.idEmpleado = idEmpleado;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}