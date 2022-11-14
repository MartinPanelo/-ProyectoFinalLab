/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author ezequ
 */
public class Reparacion {
    
    private int id;
    private Bicicleta biclicleta;
    private Servicio servicio;
    private boolean estado;
    private double precio_final;
    private LocalDate fecha_entrada;

    public Reparacion() {
    }

    public Reparacion(int id, Bicicleta biclicleta, Servicio servicio, boolean estado, double precio_final, LocalDate fecha_entrada) {
        this.id = id;
        this.biclicleta = biclicleta;
        this.servicio = servicio;
        this.estado = estado;
        this.precio_final = precio_final;
        this.fecha_entrada = fecha_entrada;
    }

    public Reparacion(Bicicleta biclicleta, Servicio servicio, boolean estado, double precio_final, LocalDate fecha_entrada) {
        this.biclicleta = biclicleta;
        this.servicio = servicio;
        this.estado = estado;
        this.precio_final = precio_final;
        this.fecha_entrada = fecha_entrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bicicleta getBiclicleta() {
        return biclicleta;
    }

    public void setBiclicleta(Bicicleta biclicleta) {
        this.biclicleta = biclicleta;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio_final() {
        return precio_final;
    }

    public void setPrecio_final(double precio_final) {
        this.precio_final = precio_final;
    }

    public LocalDate getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(LocalDate fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.biclicleta);
        hash = 29 * hash + Objects.hashCode(this.servicio);
        hash = 29 * hash + (this.estado ? 1 : 0);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.precio_final) ^ (Double.doubleToLongBits(this.precio_final) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.fecha_entrada);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reparacion other = (Reparacion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio_final) != Double.doubleToLongBits(other.precio_final)) {
            return false;
        }
        if (!Objects.equals(this.biclicleta, other.biclicleta)) {
            return false;
        }
        if (!Objects.equals(this.servicio, other.servicio)) {
            return false;
        }
        return Objects.equals(this.fecha_entrada, other.fecha_entrada);
    }

    @Override
    public String toString() {
        return "Reparacion{" + "id=" + id + ", biclicleta=" + biclicleta + ", servicio=" + servicio + ", estado=" + estado + ", precio_final=" + precio_final + ", fecha_entrada=" + fecha_entrada + '}';
    }
    
    
    
}
