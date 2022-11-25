/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.taller;

import com.mycompany.taller.entidades.Bicicleta;
import com.mycompany.taller.entidades.Cliente;
import com.mycompany.taller.entidades.Item_detalle;
import com.mycompany.taller.entidades.Reparacion;
import com.mycompany.taller.entidades.Repuesto;
import com.mycompany.taller.entidades.Servicio;
import com.mycompany.taller.persistencia.BicicletaData;
import com.mycompany.taller.persistencia.ClienteData;
import com.mycompany.taller.persistencia.Conexion;
import com.mycompany.taller.persistencia.Item_detalleData;
import com.mycompany.taller.persistencia.ReparacionData;
import com.mycompany.taller.persistencia.RepuestoData;
import com.mycompany.taller.persistencia.ServicioData;
import java.sql.Connection;
import java.time.LocalDate;

/**
 *
 * @author martin
 */
public class Taller {

    public static void main(String[] args) {

      // "TODOS LOS BORRADOS SON LOGICOS"
        
//------SERVICIO---------------------------------------------------------------------
        
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
        System.out.println("\nLista de servicios que estan dados de baja:\n");
        System.out.println(sData.listarServicios(true));
        
        //listo todos los servicios que estan dados de alta
        System.out.println("\nLista de servicios que estan dados de alta:\n");
        System.out.println(sData.listarServicios(false));
        
        //dar de baja a un servicio
        sData.darDeBajaServicio(6);
        
        //dar de alta a un servicio
        sData.darDeAltaServicio(5);
  
//------REPUESTO---------------------------------------------------------------------

        //coneccion de repuestoData
        RepuestoData rData = new RepuestoData(conDataBase);
        
        //agregar repuesto
        Repuesto r1 = new Repuesto("Cubiertas", 48567, "Cubiertas para bicicleta", 2000, false);
        
        rData.guardarRepuesto(r1);
        
        //buscar repuesto por ID
        System.out.println("\nBuscar un repuesto por id:\n");
        System.out.println(rData.buscarRepuestoPorID(5));
        
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

//------CLIENTE---------------------------------------------------------------------

        //Conexion de ClienteData
        ClienteData cData = new ClienteData(conDataBase);

        //Guardar un cliente
        Cliente unCliente = new Cliente("El Chapo", "Guzman", 38439, "mexico", 266487432, true);
        cData.guardarCliente(unCliente);

        //busco un cliente por ID
        System.out.println("\nCliente por ID : \n" + cData.buscarCliente(3));

        //actualizar cliente
        Cliente ClienteActializado = cData.buscarCliente(3);
        ClienteActializado.setCelular(123123);
        cData.actualizarCliente(ClienteActializado);

        //listo todos los clientes que estan dados de baja 
        System.out.println("\nLista de clientes que estan dados de baja: \n"+cData.listarClientes(true));
        
        //listo todos los clientes que estan dados de alta 
        System.out.println("\nLista de clientes que estan dados de alta: \n"+cData.listarClientes(false));
        
        //dar de baja a un cliente por id
        cData.darDeBajaCliente(3);
        
        //dar de alta a un cliente
        cData.darDeAltaCliente(6);

//------BICICLETA---------------------------------------------------------------------

        //Conexxion de BicicletaData                
        BicicletaData bData = new BicicletaData(conDataBase);
          
        //Creo una biclieta /no existen las bicicletas sin dueños          
        Cliente clientedb = cData.buscarCliente(2);//es un cliente de la base de datos y borrado = false//          
        Bicicleta unaBici = new Bicicleta(1994, "DosRuedas", "todo terrreno", "Verde", clientedb, false);          
        bData.guardarBicicleta(unaBici);
          
        //Buscar por ID          
        System.out.println("\nbici por ID : \n"+bData.buscarBicicletaPorID(4));
          
        //Listar todas las bicis que estan dadas de baja
        System.out.println("\nlista de bicicletas que estan dados de baja: \n"+bData.listarBicicletas(true));
        
        //Listar todas las bicis que estan dadas de alta
        System.out.println("\nlista de bicicletas que estan dadas de alta: \n"+bData.listarBicicletas(false));
     
        //actualizar datos de una bicicleta        
        Bicicleta unabici = bData.buscarBicicletaPorID(4);      
        unabici.setColor("Zaffre");
        bData.actualizarBicicleta(unabici);
          
        //Dar de baja a una bicicleta
        bData.darDeBajaBicicleta(4);
        
        //Dar de alta a una bicicleta
        bData.darDeAltaBicicleta(5);
        
//------REPARACIÓN--------------------------------------------------------------------- 

        //Conexion de ReparacionData
        ReparacionData reData = new ReparacionData(conDataBase);
        
        //Creo una reparación
        Bicicleta bicidb = bData.buscarBicicletaPorID(6);
        Servicio serviciodb = sData.buscarServicioPorID(1);
        Reparacion nuevaReparacion = new Reparacion(bicidb, serviciodb, false, 0, LocalDate.of(2022, 11, 24), false);
        
        //Busco por ID una reparación
        System.out.println("\nReparación por ID: \n" + reData.buscarReparacionPorID(2));
        
        //listar todas las reparaciones que estan dadas de baja
        System.out.println("\nlista de reparaciones que estan dadas de bajas: \n"+ reData.listarReparaciones(true));
        
        //listar todas las reparaciones que estan dadas de alta
        System.out.println("\nlista de reparaciones que estan dadas de altas: \n"+ reData.listarReparaciones(false));
        
        //actualizar datos de una reparación
        Servicio serviActualizado = sData.buscarServicioPorID(2);
        Reparacion reparacionActualizada = reData.buscarReparacionPorID(5);
        reparacionActualizada.setServicio(serviActualizado); //Cambio de servicio
        
        //Dar de baja a una reparación
        reData.darDeBajaReparacion(4);
        
        //Dar de alta a una reparación
        reData.darDeAltaReparacion(5);
        
//------ITEM-DETALLE---------------------------------------------------------------------
        
        //Conexion de Item_detalleData
        Item_detalleData iData = new Item_detalleData(conDataBase);
        
        //Creo un item
        Reparacion reparacion = reData.buscarReparacionPorID(2);
        Repuesto repuesto = rData.buscarRepuestoPorID(6);
        Item_detalle nuevoItem = new Item_detalle(reparacion, repuesto, 2, 0, false);
        
        iData.guardarItem_detalle(nuevoItem);
        
        //Busco por ID un item
        System.out.println("item detalle por ID : "+ iData.buscarItem_detallePorID(6));
        
        //listar todos los items que estan dados de baja
        System.out.println("\nlista de items que estan dados de baja: \n"+ iData.listarItem(true));
        
        //listar todas las items que estan dados de alta
        System.out.println("\nlista de items que estan dados de alta: \n"+ iData.listarItem(false));
        
        //actualizar datos de un item
        Item_detalle itemActualizado = iData.buscarItem_detallePorID(6);
        itemActualizado.setCantidad(4);
        iData.actualizarItem_detalle(itemActualizado);
        
        //Dar de baja a un item
        iData.darDeBajaItem_detalle(6);
        
        //Dar de alta a una item
        iData.darDeAltaItem_detalle(4);
        
    }
}
