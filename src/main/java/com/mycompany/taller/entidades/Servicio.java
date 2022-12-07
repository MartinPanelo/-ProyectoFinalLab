/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.entidades;

import java.util.Objects;

/**
 *
 * @author ezequ
 */
public class Servicio {
    
    private int id;
    private int codigo;
    private String descripcion;
    private double costo;
    private boolean borrado;

    public Servicio() {
    }

    public Servicio(int id, int codigo, String descripcion, double costo, boolean borrado) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.borrado = borrado;
    }

    public Servicio(int codigo, String descripcion, double costo, boolean borrado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.borrado = borrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.costo) ^ (Double.doubleToLongBits(this.costo) >>> 32));
        hash = 29 * hash + (this.borrado ? 1 : 0);
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
        final Servicio other = (Servicio) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.costo) != Double.doubleToLongBits(other.costo)) {
            return false;
        }
        if (this.borrado != other.borrado) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }

    @Override
    public String toString() {
        return "codigo: " + codigo + " , descripcion=" + descripcion ;
    }

   
    
    
}
