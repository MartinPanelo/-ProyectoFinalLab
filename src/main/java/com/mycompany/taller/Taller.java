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
        
        //listo todos los servicios que estan dados de baja
        System.out.println("Lista de servicios que estan dados de baja:");
        System.out.println(sData.listarServicios(true));
        
        //listo todos los servicios que estan dados de alta
        System.out.println("Lista de servicios que estan dados de alta:");
        System.out.println(sData.listarServicios(false));
        
        //dar de baja a un servicio
        sData.darDeBajaServicio(6);
        
        //dar de alta a un servicio
        sData.darDeAltaServicio(4);
  
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
        
        //listar todos los repuestos que estan dados de baja
        System.out.println("\nLista de repuestos que estan dados de baja:\n");
        System.out.println(rData.listarRepuestos(true));
        
        //listar todos los repuestos que estan dados de alta
        System.out.println("\nlista de repuestos que estan dados de alta:\n");
        System.out.println(rData.listarRepuestos(false));
        
        //dar de baja a un repuesto
        rData.darDeBajaRepuesto(2);
        
        //dar de alta a un repuesto
        rData.darDeAltaRepuesto(4);

//---------------------------------------------------------------------------

        //Conexion de ClienteData
        ClienteData cData = new ClienteData(conDataBase);

        //Guardar un cliente
        Cliente unCliente = new Cliente("El Chapo", "Guzman", 38439, "mexico", 266487432, true);
        cData.guardarCliente(unCliente);

        //busco un cliente por ID
        System.out.println("Cliente por ID : " + cData.buscarCliente(3));

        //actualizar cliente
        Cliente ClienteActializado = cData.buscarCliente(3);
        unCliente.setCelular(123123);
        cData.actualizarCliente(ClienteActializado);

        //listo todos los clientes que estan dados de baja 
        System.out.println("Lista de clientes que estan dados de baja: "+cData.listarClientes(true));
        
        //listo todos los clientes que estan dados de alta 
        System.out.println("Lista de clientes que estan dados de alta: "+cData.listarClientes(false));
        
        //dar de baja a un cliente por id
        cData.darDeBajaCliente(6);
        
        //dar de alta a un cliente
        cData.darDeAltaCliente(3);

//---------------------------------------------------------------------------

        //Conexxion de BicicletaData                
        BicicletaData bData = new BicicletaData(conDataBase);
          
        //Creo una biclieta /no existen las bicicletas sin dueños          
        Cliente clientedb = cData.buscarCliente(2);//es un cliente de la base de datos y borrado = false//          
        Bicicleta unaBici = new Bicicleta(1994, "DosRuedas", "todo terrreno", "Verde", clientedb, false);          
        bData.guardarBicicleta(unaBici);
          
        //Buscar por ID          
        System.out.println("bici por ID : "+bData.buscarBicicletaPorID(4));
          
        //Listar todas las bicis que estan dadas de baja
        System.out.println("lista de bicicletas que estan dados de baja: "+bData.listarBicicletas(true));
        
        //Listar todas las bicis que estan dadas de alta
        System.out.println("lista de bicicletas que estan dadas de alta: "+bData.listarBicicletas(false));
     
        //actualizar datos de una bicicleta        
        Bicicleta unabici = bData.buscarBicicletaPorID(4);      
        unabici.setColor("Zaffre");
        bData.actualizarBicicleta(unabici);
          
        //Dar de baja a una bicicleta
        bData.darDeBajaBicicleta(4);
        
        //Dar de alta a una bicicleta
        bData.darDeAltaBicicleta(5);
        
//--------------------------------------------------------------------------- 
          

    }
}
