package com.firstCRUD.firstCRUD.Gym;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="gimnasios_lima")
public class Gym {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codigoUnico;

    private String nombre;

    private String distrito;

    private String tarifa_regular_soles;

    private String membresia_premium_soles;

    private Integer capacidad_maxima;

    private String horario;

    private String servicios;

    private String telefono;

    private String email;


    public Gym() {

    }
    public Gym(Integer codigoUnico, String nombre, String distrito, String tarifa_regular_soles, String membresia_premium_soles, Integer capacidad_maxima, String horario, String servicios, String telefono, String email) {
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.distrito = distrito;
        this.tarifa_regular_soles = tarifa_regular_soles;
        this.membresia_premium_soles = membresia_premium_soles;
        this.capacidad_maxima = capacidad_maxima;
        this.horario = horario;
        this.servicios = servicios;
        this.telefono = telefono;
        this.email = email;
    }

    /*Getters and Setters*/

    public Integer getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(Integer codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTarifa_regular_soles() {
        return tarifa_regular_soles;
    }

    public void setTarifa_regular_soles(String tarifa_regular_soles) {
        this.tarifa_regular_soles = tarifa_regular_soles;
    }

    public String getMembresia_premium_soles() {
        return membresia_premium_soles;
    }

    public void setMembresia_premium_soles(String membresia_premium_soles) {
        this.membresia_premium_soles = membresia_premium_soles;
    }

    public Integer getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(Integer capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
