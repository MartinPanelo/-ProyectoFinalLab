/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.taller.vistas;

//IMPORTACIONES//
import com.mycompany.taller.persistencia.Conexion;
import com.mycompany.taller.persistencia.ClienteData;
import com.mycompany.taller.entidades.Cliente;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VistaListadoCliente extends javax.swing.JInternalFrame {

    Connection conexiondb = Conexion.getConexion();
    ClienteData cData = new ClienteData(conexiondb);
    private DefaultTableModel modeloDeTabla;
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public VistaListadoCliente() {
        initComponents();
        modeloDeTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        armarTabla();
    }

//    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRBalta = new javax.swing.JRadioButton();
        JRBbaja = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTListadoClientes = new javax.swing.JTable();
        JBAlta = new javax.swing.JButton();
        JBBaja = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        buttonGroup1.add(jRBalta);
        jRBalta.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jRBalta.setText("Alta");
        jRBalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBaltaActionPerformed(evt);
            }
        });

        buttonGroup1.add(JRBbaja);
        JRBbaja.setText("Baja");
        JRBbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBbajaActionPerformed(evt);
            }
        });

        JTListadoClientes.setBackground(new java.awt.Color(242, 242, 242));
        JTListadoClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JTListadoClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTListadoClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTListadoClientes.setName(""); // NOI18N
        JTListadoClientes.setRowHeight(25);
        JTListadoClientes.setShowGrid(true);
        jScrollPane1.setViewportView(JTListadoClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBalta)
                .addGap(65, 65, 65)
                .addComponent(JRBbaja)
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBalta)
                    .addComponent(JRBbaja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBAlta.setText("Dar alta");
        JBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAltaActionPerformed(evt);
            }
        });

        JBBaja.setText("Dar baja");
        JBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(JBAlta)
                .addGap(18, 18, 18)
                .addComponent(JBBaja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAlta)
                    .addComponent(JBBaja))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBaltaActionPerformed
        JBAlta.setEnabled(false);
        JBBaja.setEnabled(true);
        listadoClientesAlta();
    }//GEN-LAST:event_jRBaltaActionPerformed

    private void JRBbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBbajaActionPerformed
        JBAlta.setEnabled(true);
        JBBaja.setEnabled(false);
        listadoClientesBaja();
    }//GEN-LAST:event_JRBbajaActionPerformed

    private void JBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBajaActionPerformed
        int filaSelecionada = JTListadoClientes.getSelectedRow();
        Cliente clienteSelect = new Cliente();
        if (filaSelecionada != -1) {
            clienteSelect.setId((Integer) JTListadoClientes.getValueAt(filaSelecionada, 0));
            cData.darDeBajaCliente(clienteSelect.getId());
            listadoClientesAlta();
        }
    }//GEN-LAST:event_JBBajaActionPerformed

    private void JBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAltaActionPerformed
        int filaSelecionada = JTListadoClientes.getSelectedRow();
        Cliente clienteSelect = new Cliente();
        if (filaSelecionada != -1) {
            clienteSelect.setId((Integer)JTListadoClientes.getValueAt(filaSelecionada, 0));
            clienteSelect.setNombre((String.valueOf(JTListadoClientes.getValueAt(filaSelecionada, 1))));
            clienteSelect.setApellido((String.valueOf(JTListadoClientes.getValueAt(filaSelecionada, 2))));
            clienteSelect.setCelular((Long)JTListadoClientes.getValueAt(filaSelecionada, 3));
            clienteSelect.setDni((Long)JTListadoClientes.getValueAt(filaSelecionada, 4));
            cData.darDeAltaCliente(clienteSelect.getId());
            listadoClientesBaja();
            
        }
    }//GEN-LAST:event_JBAltaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlta;
    private javax.swing.JButton JBBaja;
    private javax.swing.JRadioButton JRBbaja;
    private javax.swing.JTable JTListadoClientes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBalta;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void armarTabla() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("id");
        columnas.add("Nombre");
        columnas.add("Apellido");
        columnas.add("Celular");
        columnas.add("DNI");

        for (Object aux : columnas) {
            modeloDeTabla.addColumn(aux);
        }

        JTListadoClientes.setModel(modeloDeTabla);
        JTListadoClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        JTListadoClientes.getColumnModel().getColumn(0).setMinWidth(0);
        JTListadoClientes.getColumnModel().getColumn(0).setPreferredWidth(0);

    }
    
    private void listadoClientesAlta() {
        modeloDeTabla.setNumRows(0);
        listaClientes = cData.listarClientes(false);
        for (Cliente aux : listaClientes) {
            modeloDeTabla.addRow(new Object[]{aux.getId(), aux.getNombre(), aux.getApellido(), aux.getCelular(), aux.getDni(), aux.getId()});
        }
    }
    
    private void listadoClientesBaja() {
        modeloDeTabla.setNumRows(0);
        listaClientes = cData.listarClientes(true);
        for (Cliente aux : listaClientes) {
            modeloDeTabla.addRow(new Object[]{aux.getId(), aux.getNombre(), aux.getApellido(), aux.getCelular(), aux.getDni(), aux.getId()});
        }
    }

}
