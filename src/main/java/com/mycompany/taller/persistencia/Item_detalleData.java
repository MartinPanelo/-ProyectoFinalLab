/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.persistencia;


import com.mycompany.taller.entidades.Item_detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ailen
 */
public class Item_detalleData {
    private Connection conexionData;
    private ReparacionData repaData;
    private RepuestoData repuData;
    
    public Item_detalleData(Connection connection){
    this.conexionData = connection;
    this.repuData= new RepuestoData(connection);
    this.repaData= new ReparacionData(connection);
}
    
    //guardar itemDetalle
    
    public void guardarItem_detalle (Item_detalle item){
        String query = "INSERT INTO item_detalle(id_reparacion, id_repuesto, cantidad, suma_precios, borrado) VALUES (?,?,?,?,false)";
        
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, item.getReparacion().getId());
            ps.setInt(2, item.getRepuesto().getId());
            ps.setInt(3, item.getCantidad());
            ps.setDouble(4, item.getSuma_precios()); //Valor de repuesto por cantidad de repuesto
                            
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null,"Item agregado");
            } else {
                JOptionPane.showMessageDialog(null, "Item no agregada");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                item.setId_detalle(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID del item");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en agregar item"+ex);
        }
        
    }
    //buscar itemDetalle
    public Item_detalle buscarItem_detallePorID(int id) {
        Item_detalle item = null;
        String sql = "SELECT * FROM item_detalle WHERE id_detalle = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new Item_detalle();
                item.setId_detalle(rs.getInt("id"));
                item.setReparacion(repaData.buscarReparacionPorID(rs.getInt("id_reparacion")));
                item.setRepuesto(repuData.buscarRepuestoPorID(rs.getInt("id_repuesto")));
                item.setCantidad(rs.getInt("cantidad"));
                item.setSuma_precios(rs.getDouble("suma_precios"));
                item.setBorrado(rs.getBoolean("borrado"));
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en buscar item por id."+ex);
        }

        return item;
    }
    
    
    //actualizar itemDetalle
    public void actualizarItem_detalle(Item_detalle item) { 
        String sqlQuery = "UPDATE item_detalle SET id_reparacion= ? ,id_repuesto = ? ,cantidad= ? ,suma_precios= ? WHERE id = ?";
            if (buscarItem_detallePorID(item.getId_detalle()) != null) {
            try {
            PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
            ps.setInt(1, item.getReparacion().getId());
            ps.setInt(2, item.getRepuesto().getId());
            ps.setInt(3, item.getCantidad());
            ps.setDouble(4, item.getSuma_precios());
            ps.setDouble(5, item.getId_detalle());
           
           
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se pudo actualizar el item.");
            } else  {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el item.");
            }
            
            ps.close();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en actualizar item" + ex);
        }  
            }
            
        }
    //listar itemDetalle
    public ArrayList<Item_detalle> listarItem(boolean estadito) {

        ArrayList<Item_detalle> listaItem = new ArrayList();
       
        String sql = "SELECT * FROM item_detalle WHERE borrado= ?";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            
            ps.setBoolean(1, estadito); //Estadito igual true me va atraer los que estan borrados y si es igual a false trae los que no estan borrados

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Item_detalle item = new Item_detalle();

                item.setId_detalle(rs.getInt("id"));
                item.setReparacion(repaData.buscarReparacionPorID(rs.getInt("id_reparacion")));
                item.setRepuesto(repuData.buscarRepuestoPorID(rs.getInt("id_repuesto")));
                item.setCantidad(rs.getInt("cantidad"));
                item.setSuma_precios(rs.getDouble("suma_precios"));
                item.setBorrado(rs.getBoolean("borrado"));
                
                listaItem.add(item);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la lista de item_detalle " + ex);
        }
        return listaItem;
    }
    
    //dar de baja itemDetalle
      public void darDeBajaItem_detalle (int id){
        String sql="UPDATE item_detalle SET borrado= true WHERE id = ?";
        try {
            PreparedStatement ps=conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo dar de baja el item");
            } else  {   
                JOptionPane.showMessageDialog(null, "Se dio de baja el item correctamente");
            }
         
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception " + ex);
        }
    }
    //dar de alta itemDetalle
      
      public void darDeAltaItem_detalle (int id){
        String sql="UPDATE item_detalle SET borrado= false WHERE id = ?";
        try {
            PreparedStatement ps=conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo dar de alta el item");
            } else  {   
                JOptionPane.showMessageDialog(null, "Se dio de alta el item correctamente");
            }
         
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception " + ex);
        }
    }
}
