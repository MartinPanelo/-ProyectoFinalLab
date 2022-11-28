/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.taller.vistas;

import com.mycompany.taller.entidades.Repuesto;
import com.mycompany.taller.persistencia.Conexion;
import com.mycompany.taller.persistencia.RepuestoData;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author ezequ
 */
public class VistaRepuesto extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaRepuesto
     */
    
    Connection conexiondb = Conexion.getConexion();
    RepuestoData rData = new RepuestoData(conexiondb);
    
    public VistaRepuesto() {
        initComponents();
    }
    
    //Validaciones
    public boolean validarCamposVaciosAgregar(){
     if (JTFnombre.getText().equals("") || JTFnumSerie.getText().equals("") || JTFdescripcion.getText().equals("") || JTFprecio.getText().equals("")) {
        return false;
    }
    return true;
   }
    
    public boolean validarCamposVaciosBuscar(){
        if (JTFid.getText().equals("")) {
        return false;
    }
    return true;
    }
    
    public boolean validarCamposVaciosActualizar() {
        if (JTFnombre.getText().equals("") || JTFid.getText().equals("") || JTFnumSerie.getText().equals("") || JTFdescripcion.getText().equals("") || JTFprecio.getText().equals("")) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLid = new javax.swing.JLabel();
        JLnombre = new javax.swing.JLabel();
        JLnumSerie = new javax.swing.JLabel();
        JLdescripcion = new javax.swing.JLabel();
        JLprecio = new javax.swing.JLabel();
        JTFid = new javax.swing.JTextField();
        JTFnombre = new javax.swing.JTextField();
        JTFnumSerie = new javax.swing.JTextField();
        JTFdescripcion = new javax.swing.JTextField();
        JTFprecio = new javax.swing.JTextField();
        JBbuscar = new javax.swing.JButton();
        JBagregar = new javax.swing.JButton();
        JBactualizar = new javax.swing.JButton();
        JBlimpiar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Gestion de repuesto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP), "Gestión de repuesto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Constantia", 0, 16))); // NOI18N

        JLid.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLid.setText("ID");

        JLnombre.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLnombre.setText("Nombre");

        JLnumSerie.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLnumSerie.setText("Número de serie");

        JLdescripcion.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLdescripcion.setText("Descripción");

        JLprecio.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        JLprecio.setText("Precio");

        JBbuscar.setText("Buscar");
        JBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbuscarActionPerformed(evt);
            }
        });

        JBagregar.setText("Agregar");
        JBagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBagregarActionPerformed(evt);
            }
        });

        JBactualizar.setText("Actualizar");
        JBactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBactualizarActionPerformed(evt);
            }
        });

        JBlimpiar.setText("Limpiar");
        JBlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLid)
                    .addComponent(JLnombre)
                    .addComponent(JLnumSerie)
                    .addComponent(JLprecio)
                    .addComponent(JLdescripcion))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFnombre)
                            .addComponent(JTFnumSerie)
                            .addComponent(JTFdescripcion)
                            .addComponent(JTFprecio)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBbuscar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBlimpiar)
                        .addGap(35, 35, 35)
                        .addComponent(JBagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(JBactualizar)
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLid)
                    .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBbuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnombre)
                    .addComponent(JTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnumSerie)
                    .addComponent(JTFnumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLdescripcion)
                    .addComponent(JTFdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLprecio)
                    .addComponent(JTFprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBagregar)
                    .addComponent(JBactualizar)
                    .addComponent(JBlimpiar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botón Buscar:
    private void JBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbuscarActionPerformed
        try {
        if (validarCamposVaciosBuscar()) {
        Repuesto r = new Repuesto();
        r = rData.buscarRepuestoPorID(Integer.parseInt(JTFid.getText()));
        JTFnombre.setText(r.getNombre());
        JTFnumSerie.setText(String.valueOf(r.getNumero_serie()));
        JTFdescripcion.setText(r.getDescripcion());
        JTFprecio.setText(String.valueOf(r.getPrecio()));
        } else  {
            JOptionPane.showMessageDialog(null, "Falta ingresar el id para buscar.");
        }
        } catch (NumberFormatException | NullPointerException ex)  {
            JOptionPane.showMessageDialog(null, "El id ingresado contiene caracteres o es invalido." );    
        }        
    }//GEN-LAST:event_JBbuscarActionPerformed

    //Botón Limpiar
    private void JBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlimpiarActionPerformed
        JTFdescripcion.setText("");
        JTFnombre.setText("");
        JTFnumSerie.setText("");
        JTFid.setText("");
        JTFprecio.setText("");
    }//GEN-LAST:event_JBlimpiarActionPerformed

    //Botón Agregar
    private void JBagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBagregarActionPerformed
        try {
        if (validarCamposVaciosAgregar()) {
            Repuesto r = new Repuesto();
            r.setNombre(JTFnombre.getText());
            r.setPrecio(Double.parseDouble(JTFprecio.getText()));
            r.setDescripcion(JTFdescripcion.getText());
            r.setNumero_serie(Long.parseLong(JTFnumSerie.getText()));
            rData.guardarRepuesto(r);
        } else  {
            JOptionPane.showMessageDialog(null, "Faltan llenar campos");
        }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema revise los datos ingresados.");
        }
    }//GEN-LAST:event_JBagregarActionPerformed

    //Botón Actualizar
    private void JBactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBactualizarActionPerformed
        try {
        if (validarCamposVaciosActualizar()) {
        Repuesto r = new Repuesto();
        r.setNombre(JTFnombre.getText());
        r.setPrecio(Double.parseDouble(JTFprecio.getText()));
        r.setDescripcion(JTFdescripcion.getText());
        r.setNumero_serie(Long.parseLong(JTFnumSerie.getText()));
        r.setId(Integer.parseInt(JTFid.getText()));
        rData.actualizarRepuesto(r);
        } else  {   
            JOptionPane.showMessageDialog(null, "Faltan llenar campos");
        }
        } catch (NumberFormatException ex)  {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema revise los datos ingresados. " + ex);
        }
    }//GEN-LAST:event_JBactualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBactualizar;
    private javax.swing.JButton JBagregar;
    private javax.swing.JButton JBbuscar;
    private javax.swing.JButton JBlimpiar;
    private javax.swing.JLabel JLdescripcion;
    private javax.swing.JLabel JLid;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JLabel JLnumSerie;
    private javax.swing.JLabel JLprecio;
    private javax.swing.JTextField JTFdescripcion;
    private javax.swing.JTextField JTFid;
    private javax.swing.JTextField JTFnombre;
    private javax.swing.JTextField JTFnumSerie;
    private javax.swing.JTextField JTFprecio;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
