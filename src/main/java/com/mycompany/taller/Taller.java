/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.taller;

import com.mycompany.taller.persistencia.Conexion;
import java.sql.Connection;

/**
 *
 * @author martin
 */
public class Taller {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Connection conDataBase = Conexion.getConexion();
    }
}
