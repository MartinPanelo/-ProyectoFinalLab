/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.persistencia;

import com.mycompany.taller.entidades.Repuesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ezequ
 */
public class RepuestoData {
    
    private Connection conexionData;

    public RepuestoData(Connection connection) {
        this.conexionData = connection;
    }
    
    public void guardarRepuesto(Repuesto r) {

        String query = "INSERT INTO repuesto(numero_serie, nombre, descripcion, precio, borrado) VALUES (?, ?, ?, ?, 0)";
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, r.getNumero_serie());
            ps.setString(2, r.getNombre());
            ps.setString(3, r.getDescripcion());
            ps.setDouble(4, r.getPrecio());
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Repuesto agregado");
            } else {
                JOptionPane.showMessageDialog(null, "Repuesto no agregado");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                r.setId(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID del repuesto");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en agregar repuesto");
        }

    }
    
    public Repuesto buscarRepuestoPorID(int id) {
        Repuesto r = null;
        String sql = "SELECT * FROM repuesto WHERE id = ? AND borrado = 0";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r = new Repuesto();
                r.setId(rs.getInt("id"));
                r.setNumero_serie(rs.getLong("numero_serie"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setPrecio(rs.getDouble("precio"));
                r.setBorrado(rs.getBoolean("borrado"));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en buscar repuesto por id.");
        }
//        if (r == null) {
//            JOptionPane.showMessageDialog(null, "No se pudo buscar por id porque no existe un repuesto con ese id.");
//        }
        return r;
    }
    
    public void actualizarRepuesto(Repuesto r) {
        String sqlQuery = "UPDATE repuesto SET numero_serie= ? ,nombre= ? ,descripcion= ? ,precio= ?, borrado= ? WHERE id = ?";
            if (buscarRepuestoPorID(r.getId()) != null) {
            try {
            PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
            ps.setLong(1, r.getNumero_serie());
            ps.setString(2, r.getNombre());
            ps.setString(3, r.getDescripcion());
            ps.setDouble(4, r.getPrecio());
            ps.setDouble(5, r.getId());
            ps.setBoolean(6, r.isBorrado());
           
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se pudo actualizar el repuesto.");
            } else  {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el repuesto.");
            }
            
            ps.close();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en actualizar repuesto");
        }  
            }
            
        }
    
    public ArrayList<Repuesto> listarRepuestos() {

        ArrayList<Repuesto> l1 = new ArrayList();

        String sql = "SELECT * FROM repuesto WHERE borrado= 0";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Repuesto r = new Repuesto();

                r.setId(rs.getInt("id"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setNumero_serie(rs.getLong("numero_serie"));
                r.setBorrado(rs.getBoolean("borrado"));
                r.setPrecio(rs.getDouble("precio"));

                l1.add(r);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la lista de repuestos " + ex);
        }
        return l1;
    }
    
    
        public void borrarRepuesto (int id){
        String sql="UPDATE repuesto SET borrado= 1 WHERE id = ?";
        try {
            PreparedStatement ps=conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el repuesto");
            } else  {   
                JOptionPane.showMessageDialog(null, "Se elimino el repuesto correctamente");
            }
         
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception "+ ex);
        }
    }
      
}
