/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.persistencia;

import com.mycompany.taller.entidades.Bicicleta;
//import com.mycompany.taller.entidades.Cliente;
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
public class BicicletaData {
     private Connection conexionData;
     private ClienteData cData;
    
    public BicicletaData (Connection connection){
        this.conexionData = connection;
        this.cData= new ClienteData(connection);
    }
    
    public void guardarBicicleta (Bicicleta bici){
        String query = "INSERT INTO `bicicleta`(numero_serie, tipo, color, cliente, borrado) VALUES (?,?,?,?,0)";
        
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, bici.getNumero_serie());
            ps.setString(2, bici.getTipo());
            ps.setString(3, bici.getColor());
            ps.setInt(4, bici.getCliente().getId());// Corroborar que sea el id lo que corresponde
           // ps.setBoolean(5, bici.getBorrado());
            
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null,"Bicicleta agregada");
            } else {
                JOptionPane.showMessageDialog(null, "Bicicleta no agregada");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                bici.setId(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID de la bicicleta");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en agregar bicicleta");
        }
    }
        public Bicicleta buscarBicicletaPorID(int id) {
        Bicicleta bici = null;
        String sql = "SELECT * FROM bicicleta WHERE id = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bici = new Bicicleta();
                bici.setId(rs.getInt("id"));
                bici.setNumero_serie(rs.getLong("numero_serie"));
                bici.setTipo(rs.getString("tipo"));
                bici.setColor(rs.getString("color"));
                bici.setCliente(cData.buscarCliente(rs.getInt("cliente")));
                bici.setBorrado(rs.getBoolean("borrado"));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en buscar bicicleta por id.");
        }

        return bici;
    }
        // actualizar bicicleta
         public void actualizarBicicleta(Bicicleta bici) {
        String sqlQuery = "UPDATE bicicleta SET numero_serie= ? ,tipo= ? ,color= ? ,cliente= ?, borrado= ? WHERE id = ?";
            if (buscarBicicletaPorID(bici.getId()) != null) {
            try {
            PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
            ps.setLong(1, bici.getNumero_serie());
            ps.setString(2, bici.getTipo());
            ps.setString(3, bici.getColor());
            ps.setInt(4, bici.getCliente().getId());
            ps.setDouble(5, bici.getId());
            ps.setBoolean(6, bici.getBorrado()); //  los chicos tienen is? preguntar
           
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se pudo actualizar la bicicleta.");
            } else  {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la bicicleta.");
            }
            
            ps.close();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en actualizar bicicleta");
        }  
            }
            
        }
        // listar bicicleta
        public ArrayList<Bicicleta> listarBicicletas() {

        ArrayList<Bicicleta> listaBici = new ArrayList();

        String sql = "SELECT * FROM bicicleta WHERE borrado= 0";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Bicicleta bici = new Bicicleta();

                bici.setId(rs.getInt("id"));
                bici.setTipo(rs.getString("tipo"));
                bici.setColor(rs.getString("color"));
                bici.setNumero_serie(rs.getLong("numero_serie"));
                bici.setBorrado(rs.getBoolean("borrado"));
                bici.setCliente(cData.buscarCliente(rs.getInt("cliente")));

                listaBici.add(bici);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la lista de bicicletas " + ex);
        }
        return listaBici;
    }
        
        //borrar bicicleta
    public void borrarBicicleta (int id){
        String sql="UPDATE bicicleta SET borrado= 1 WHERE id = ?";
        try {
            PreparedStatement ps=conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la bicicleta");
            } else  {   
                JOptionPane.showMessageDialog(null, "Se elimino la bicicleta correctamente");
            }
         
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception "+ ex);
        }
    }
}
