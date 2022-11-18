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
public class Bicicleta {
    
    private int id;
    private long numero_serie;
    private String tipo;
    private String color;
    private Cliente cliente;
    private Boolean borrado;

    public Bicicleta() {
    }

    public Bicicleta(int id, long numero_serie, String tipo, String color, Cliente cliente, Boolean borrado) {
        this.id = id;
        this.numero_serie = numero_serie;
        this.tipo = tipo;
        this.color = color;
        this.cliente = cliente;
        this.borrado = borrado;
    }

    public Bicicleta(long numero_serie, String tipo, String color, Cliente cliente, Boolean borrado) {
        this.numero_serie = numero_serie;
        this.tipo = tipo;
        this.color = color;
        this.cliente = cliente;
        this.borrado = borrado; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(long numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + (int) (this.numero_serie ^ (this.numero_serie >>> 32));
        hash = 17 * hash + Objects.hashCode(this.tipo);
        hash = 17 * hash + Objects.hashCode(this.color);
        hash = 17 * hash + Objects.hashCode(this.cliente);
        hash = 17 * hash + Objects.hashCode(this.borrado ? 1 : 0);
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
        final Bicicleta other = (Bicicleta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numero_serie != other.numero_serie) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
        
     }

    @Override
    public String toString() {
        return "Bicicleta{" + "id=" + id + ", numero_serie=" + numero_serie + ", tipo=" + tipo + ", color=" + color + ", cliente=" + cliente + ", borrado =" + borrado +'}';
    }
    
    
    
}
