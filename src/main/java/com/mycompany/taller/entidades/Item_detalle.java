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
public class Item_detalle {
    
    private int id_detalle;
    private Reparacion reparacion;
    private Repuesto repuesto;
    private int cantidad;
    private double suma_precios;

    public Item_detalle() {
    }

    public Item_detalle(int id_detalle, Reparacion reparacion, Repuesto repuesto, int cantidad, double suma_precios) {
        this.id_detalle = id_detalle;
        this.reparacion = reparacion;
        this.repuesto = repuesto;
        this.cantidad = cantidad;
        this.suma_precios = suma_precios;
    }

    public Item_detalle(Reparacion reparacion, Repuesto repuesto, int cantidad, double suma_precios) {
        this.reparacion = reparacion;
        this.repuesto = repuesto;
        this.cantidad = cantidad;
        this.suma_precios = suma_precios;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSuma_precios() {
        return suma_precios;
    }

    public void setSuma_precios(double suma_precios) {
        this.suma_precios = suma_precios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_detalle;
        hash = 29 * hash + Objects.hashCode(this.reparacion);
        hash = 29 * hash + Objects.hashCode(this.repuesto);
        hash = 29 * hash + this.cantidad;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.suma_precios) ^ (Double.doubleToLongBits(this.suma_precios) >>> 32));
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
        final Item_detalle other = (Item_detalle) obj;
        if (this.id_detalle != other.id_detalle) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.suma_precios) != Double.doubleToLongBits(other.suma_precios)) {
            return false;
        }
        if (!Objects.equals(this.reparacion, other.reparacion)) {
            return false;
        }
        return Objects.equals(this.repuesto, other.repuesto);
    }

    @Override
    public String toString() {
        return "Item_detalle{" + "id_detalle=" + id_detalle + ", reparacion=" + reparacion + ", repuesto=" + repuesto + ", cantidad=" + cantidad + ", suma_precios=" + suma_precios + '}';
    }
    
    
    
}
