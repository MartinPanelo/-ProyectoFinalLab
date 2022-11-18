/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.taller;

import com.mycompany.taller.entidades.Repuesto;
import com.mycompany.taller.entidades.Servicio;
import com.mycompany.taller.persistencia.Conexion;
import com.mycompany.taller.persistencia.RepuestoData;
import com.mycompany.taller.persistencia.ServicioData;
import java.sql.Connection;

/**
 *
 * @author martin
 */
public class Taller {
    
    public static void main(String[] args) {
        
        Connection conDataBase = Conexion.getConexion();
        
        //coneccion de servicioData
        ServicioData sData = new ServicioData(conDataBase);
        
        //Creo y agrego un servicio a la database
        Servicio servi = new Servicio(2020, "limpieza de cuadro", 1000,true);
        
        sData.crearServicio(servi);
        
        //busco un servicio por id
        System.out.println("busco un servicio por id (2)");
        System.out.println(sData.buscarServicioPorID(2)+"\n");
        
        
        //actualizo un servicio
        Servicio serviactualizar = sData.buscarServicioPorID(1);
        serviactualizar.setCosto(1000);
        
        sData.actualizarServicio(serviactualizar);
        
        //listo todos los servicios
        System.out.println("Listo todos los servicios");
        System.out.println(sData.listarServicios());
        
        //coneccion de repuestoData
        RepuestoData rData = new RepuestoData(conDataBase);
        
        //agregar repuesto
        Repuesto r1 = new Repuesto("Cubiertas", 48567, "Cubiertas para bicicleta", 2000, false);
        
        rData.guardarRepuesto(r1);
        
        //buscar repuesto por ID
        System.out.println("\nBuscar un repuesto por id:\n");
        System.out.println(rData.buscarRepuestoPorID(4));
        
        //actualizar un repuesto(Pendiente)
        Repuesto rActualizado = rData.buscarRepuestoPorID(6);
        rActualizado.setPrecio(2500);
        
        rData.actualizarRepuesto(rActualizado);
        
        //listar todos los repuestos
        System.out.println("\nMostrar todos los repuestos registrados:\n");
        System.out.println(rData.listarRepuestos());
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
