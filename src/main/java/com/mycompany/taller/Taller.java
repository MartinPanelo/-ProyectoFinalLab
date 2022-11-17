/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.taller;

import com.mycompany.taller.entidades.Servicio;
import com.mycompany.taller.persistencia.Conexion;
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
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
