/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.persistencia;

import com.mycompany.taller.entidades.Servicio;
import com.mycompany.taller.vistas.VistaServicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author martin
 */
public class ServicioData {

    private Connection conexionData;

    public ServicioData(Connection connection) {
        this.conexionData = connection;
    }

    public void crearServicio(Servicio servicio) {

        String query = "INSERT INTO servicio(codigo, descripcion, costo, borrado) VALUES (?, ?, ?,false)";
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, servicio.getCodigo());
            ps.setString(2, servicio.getDescripcion());
            ps.setDouble(3, servicio.getCosto());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Nuevo servicio creado");
            } else {
                JOptionPane.showMessageDialog(null, "No se creo el servicio");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                servicio.setId(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID");
            }

            ps.close();

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El codigo ingresado ya se esta usando. " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error tratando de crear el servicio. " + ex);
        }

    }

    public Servicio buscarServicioPorID(int id) {
        Servicio s = null;
        String sql = "SELECT * FROM servicio WHERE id = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Servicio();
                s.setId(rs.getInt("id"));
                s.setCodigo(rs.getInt("codigo"));
                s.setDescripcion(rs.getString("descripcion"));
                s.setCosto(rs.getDouble("costo"));
                s.setBorrado(rs.getBoolean("borrado"));

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en buscar un servicio por id. " + ex);
        }
        return s;
    }

    public void actualizarServicio(Servicio s) {
        String sqlQuery = "UPDATE servicio SET codigo= ? ,descripcion= ? ,costo= ? WHERE id = ?";
        if (buscarServicioPorID(s.getId()) != null) {
            try {
                PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
                ps.setInt(1, s.getCodigo());
                ps.setString(2, s.getDescripcion());
                ps.setDouble(3, s.getCosto());
                ps.setInt(4, s.getId());

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Se pudo actualizar el servicio.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el servicio.");
                }

                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se produjo un error. tratando de actualizar un srvicio" + ex);
            }
        }

    }

    public ArrayList<Servicio> listarServicios(boolean estadito) {

        ArrayList<Servicio> listaS = new ArrayList();

        String sql = "SELECT * FROM servicio WHERE borrado= ?";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ps.setBoolean(1, estadito); //Estadito igual true me va atraer los que estan borrados y si es igual a false trae los que no estan borrados

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Servicio s = new Servicio();

                s.setId(rs.getInt("id"));
                s.setCosto(rs.getDouble("costo"));
                s.setDescripcion(rs.getString("descripcion"));
                s.setCodigo(rs.getInt("codigo"));
                s.setBorrado(rs.getBoolean("borrado"));

                listaS.add(s);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la lista de servicios " + ex);
        }
        return listaS;
    }

    public void darDeBajaServicio(int id) {
        String sql = "UPDATE servicio SET borrado= true WHERE id = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo dar de baja al servicio");
            } else {
                JOptionPane.showMessageDialog(null, "Se dio de baja al servicio correctamente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception " + ex);
        }
    }

    public void darDeAltaServicio(int id) {
        String sql = "UPDATE servicio SET borrado= false WHERE id = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo dar de alta al servicio");
            } else {
                JOptionPane.showMessageDialog(null, "Se dio de alta al servicio correctamente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception " + ex);
        }
    }

}
