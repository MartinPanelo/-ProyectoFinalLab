/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.taller;

import com.mycompany.taller.entidades.Bicicleta;
import com.mycompany.taller.entidades.Cliente;
import com.mycompany.taller.entidades.Repuesto;
import com.mycompany.taller.entidades.Servicio;
import com.mycompany.taller.persistencia.BicicletaData;
import com.mycompany.taller.persistencia.ClienteData;
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

      // "TODOS LOS BORRADOS SON LOGICOS"
        
        
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
  
//---------------------------------------------------------------------------

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

//---------------------------------------------------------------------------

        //Conexion de ClienteData
        ClienteData cData = new ClienteData(conDataBase);

        //Guardar un cliente
        Cliente unCliente = new Cliente("El Chapo", "Guzman", 38439, "mexico", 26648743, true);
        cData.guardarCliente(unCliente);

        //busco un cliente por ID
        System.out.println("Cliente por ID : " + cData.buscarCliente(3));

        //actualizar cliente
        Cliente ClienteActializado = cData.buscarCliente(3);
        unCliente.setCelular(123123);
        cData.actualizarCliente(ClienteActializado);

        //listo todos los clientes no borrados
        System.out.println("Lista de clientes : "+cData.listarClientes());
        
        //borro un cliente por id
        cData.borrarCliente(6);

//---------------------------------------------------------------------------

        //Conexxion de BicicletaData                
        BicicletaData bData = new BicicletaData(conDataBase);
          
        //Creo una biclieta /no existen las bicicletas sin dueños          
        Cliente clientedb = cData.buscarCliente(2);//es un cliente de la base de datos y borrado = false//          
        Bicicleta unaBici = new Bicicleta(1994, "DosRuedas", "todo terrreno", "Verde", clientedb, false);          
        bData.guardarBicicleta(unaBici);
          
        //Buscar por ID          
        System.out.println("bici por ID : "+bData.buscarBicicletaPorID(4));
          
        //Listar todas las bicis no borradas
        System.out.println("lista de bicicletas : "+bData.listarBicicletas());
     
        //actualizar datos de una bicicleta        
        Bicicleta unabici = bData.buscarBicicletaPorID(4);      
        unabici.setColor("Zaffre");
        bData.actualizarBicicleta(unabici);
          
        //Borrar una bicicleta
        bData.borrarBicicleta(5);
          
          
          
          
          
          
          
          
          
          

        







    }
}
