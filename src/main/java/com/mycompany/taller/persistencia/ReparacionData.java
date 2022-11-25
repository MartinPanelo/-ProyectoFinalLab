/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.persistencia;

import com.mycompany.taller.entidades.Bicicleta;
import com.mycompany.taller.entidades.Reparacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ezequ
 */
public class ReparacionData {
    
    
    
    private Connection conexionData;
    private BicicletaData bData;
    private ServicioData sData;
    private ClienteData cData;

    public ReparacionData(Connection connection) {
        this.conexionData = connection;
        this.bData = new BicicletaData(connection);
        this.sData = new ServicioData(connection);
        this.cData = new ClienteData(connection);
    }
    
    public void crearReparacion(Reparacion reparacion) {

        String query = "INSERT INTO reparacion(id_bicicleta, id_servicio, estado, precio_final, fecha_entrada, borrado) VALUES (?, ?, ?, ?, ?, false)";
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reparacion.getBiclicleta().getId());
            ps.setInt(2, reparacion.getServicio().getId());
            ps.setBoolean(3, reparacion.isEstado());
            ps.setDouble(4, reparacion.getPrecio_final()); // precio del servicio + precio total de repuestos + 15% sobre el total
            ps.setDate(5, Date.valueOf(reparacion.getFecha_entrada()));
            ps.setBoolean(6, reparacion.isBorrado());
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Nueva reparación creada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear la reparación");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                reparacion.setId(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error tratando de crear la reparación. " + ex);
        }

    }
    
    public Reparacion buscarReparacionPorID(int id) {
        Reparacion r = null;
        String sql = "SELECT * FROM reparacion WHERE id = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r = new Reparacion();
                r.setId(rs.getInt("id"));
                r.setBiclicleta(bData.buscarBicicletaPorID(rs.getInt("id_bicicleta")));
                r.setServicio(sData.buscarServicioPorID(rs.getInt("id_servicio")));
                r.setEstado(rs.getBoolean("estado"));
                r.setPrecio_final(rs.getDouble("precio_final"));
                r.setFecha_entrada(rs.getDate("fecha_entrada").toLocalDate());
                r.setBorrado(rs.getBoolean("borrado"));

            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. al buscar una reparacion por id. "+ex);
        }

        return r;
    }
    
    public void actualizarReparacion(Reparacion r) {
        String sqlQuery = "UPDATE reparacion SET id_bicicleta= ? ,id_servicio= ? ,estado= ?, precio_final= ?, fecha_entrada= ? WHERE id = ?";
            if (buscarReparacionPorID(r.getId()) != null) {
            try {
            PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
            ps.setInt(1, r.getBiclicleta().getId());
            ps.setInt(2, r.getServicio().getId());
            ps.setBoolean(3, r.isEstado());
            ps.setDouble(4, r.getPrecio_final()); // precio del servicio + precio total de repuestos + 15% sobre el total
            ps.setDate(5, Date.valueOf(r.getFecha_entrada()));
              
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se pudo actualizar la reparación.");
            } else  {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la reparación.");
            }
            
            ps.close();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. tratando de actualizar una reparación" + ex);
        }  
            }
            
    }
    
    public ArrayList<Reparacion> listarReparaciones() {

        ArrayList<Reparacion> listaR = new ArrayList();

        String sql = "SELECT * FROM reparacion WHERE borrado= false";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);           
     

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Reparacion r = new Reparacion();

                r.setId(rs.getInt("id"));
                r.setBiclicleta(bData.buscarBicicletaPorID(rs.getInt("id_bicicleta")));
                r.setServicio(sData.buscarServicioPorID(rs.getInt("id_servicio")));
                r.setEstado(rs.getBoolean("estado"));
                r.setPrecio_final(rs.getDouble("precio_final"));
                r.setFecha_entrada(rs.getDate("fecha_entrada").toLocalDate());
                r.setBorrado(rs.getBoolean("borrado"));

                listaR.add(r);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la lista de reparaciónes "+ex);
        }
        return listaR;
    }
    
    public void borrarReparacion (int id){
        String sql="UPDATE reparacion SET borrado= true WHERE id = ?";
        try {
            PreparedStatement ps=conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se borro la reparación");
            } else  {   
                JOptionPane.showMessageDialog(null, "Se borro reparación correctamente");
            }
         
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception " + ex);
        }
    }
    
    
    public ArrayList<Bicicleta> buscarBicicletasPorServicio(int id_servicio) {

        ArrayList<Bicicleta> bicicletasPorServicio = new ArrayList();

        String sql = "SELECT id_bicicleta FROM reparacion WHERE id_servicio = ?";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            
            ps.setInt(1, id_servicio); 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Bicicleta bici = bData.buscarBicicletaPorID(rs.getInt("id_bicicleta"));
                
                bicicletasPorServicio.add(bici);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la lista de bicicletas por servicio "+ex);
        }
        return bicicletasPorServicio;
    }
     
}
