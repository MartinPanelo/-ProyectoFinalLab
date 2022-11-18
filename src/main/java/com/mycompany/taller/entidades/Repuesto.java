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
public class Repuesto {
    
    private int id;
    private String nombre;
    private long numero_serie;
    private String descripcion;
    private double precio;
    private boolean borrado;

    public Repuesto() {
    }

    public Repuesto(int id, String nombre, long numero_serie, String descripcion, double precio, boolean borrado) {
        this.id = id;
        this.nombre = nombre;
        this.numero_serie = numero_serie;
        this.descripcion = descripcion;
        this.precio = precio;
        this.borrado = borrado;
    }

    public Repuesto(String nombre, long numero_serie, String descripcion, double precio, boolean borrado) {
        this.nombre = nombre;
        this.numero_serie = numero_serie;
        this.descripcion = descripcion;
        this.precio = precio;
        this.borrado = borrado;
        
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(long numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + (int) (this.numero_serie ^ (this.numero_serie >>> 32));
        hash = 79 * hash + Objects.hashCode(this.descripcion);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 79 * hash + (this.borrado ? 1 : 0);
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
        final Repuesto other = (Repuesto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numero_serie != other.numero_serie) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.borrado != other.borrado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }

    @Override
    public String toString() {
        return "Repuesto{" + "id=" + id + ", nombre=" + nombre + ", numero_serie=" + numero_serie + ", descripcion=" + descripcion + ", precio=" + precio + ", borrado=" + borrado + '}';
    }
    
    }

    
   
