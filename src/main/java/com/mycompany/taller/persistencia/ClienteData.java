package com.mycompany.taller.persistencia;

import com.mycompany.taller.entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteData {
    
    private Connection conexionData;
    
    public ClienteData(Connection connection){
        this.conexionData = connection;
    }
    
    public void guardarCliente(Cliente cliente) {

        String query = "INSERT INTO `cliente`(`nombre`, `apellido`, `dni`, `domicilio`, `celular`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setLong(3, cliente.getDni());
            ps.setString(4, cliente.getDomicilio());
            ps.setLong(5, cliente.getCelular());
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente registrado");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no registrado");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
            } 
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Un error a ocurrido");
        }

    }
    
    public Cliente buscarCliente(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setCelular(rs.getLong("celular"));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Un error a ocurrido");
        }       
        return cliente;
    }
    
    public void actualizarCliente(Cliente cliente) {
        String sqlQuery = "UPDATE `cliente` SET `nombre`= ,`apellido`= ?,`dni`= ?,`domicilio`= ?,`celular`= ? WHERE id = ?";
            if (buscarCliente(cliente.getId()) != null) {
            try {
            PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setLong(3, cliente.getDni());
            ps.setString(4, cliente.getDomicilio());
            ps.setLong(5, cliente.getCelular());
           
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado");
            } else  {
                JOptionPane.showMessageDialog(null, "Error al actualizar registro");
            }
            
            ps.close();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Un error a ocurrido");
        }  
            }
            
        }
    
}
